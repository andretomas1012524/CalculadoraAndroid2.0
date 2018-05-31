import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Andre on 31-05-2018.
 */

public class DbTabelaFuncoes implements BaseColumns {
    private SQLiteDatabase db;

    public static final String Funcoes = "funcoes";
    public static final String Nome = "name";
    public static final String Valor = "price";
    public static final String ID_Pais = "idpais";
    public DbTabelaFuncoes(SQLiteDatabase db) {
        this.db=db;
    }
    public void create(){
        db.execSQL(
                "CREATE TABLE " + Funcoes + "(" +
                        _ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                        Nome + " TEXT NOT NULL, " +
                        Valor + " Real NOT NULL," +
                        ID_Pais +" Integer ," +
                        "FOREIGN KEY ("+ID_Pais +") references " + DbTabelaPais.Pais + "(" + DbTabelaPais._ID + ")"+
                        ")"
        );
    }
}
