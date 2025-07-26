package utility;


import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize(){
        try(Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()){
            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS clients (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        surname TEXT NOT NULL,
                        is_company INTEGER NOT NULL
                    )
""");
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS tasks (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    client_id INTEGER NOT NULL,
                    date TEXT NOT NULL,
                    price REAL NOT NULL,
                    description TEXT NOT NULL,
                    task_status TEXT NOT NULL,
                    pay_status TEXT NOT NULL,
                    FOREIGN KEY (client_id) REFERENCES clients(id)
                )
""");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
