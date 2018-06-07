package com.example.andre.calculadoraandroid;

import android.app.Instrumentation;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Nonnull;

import static org.junit.Assert.*;
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DbFuncoesTest {
       @Before
        public void setUp() {
           getContext().deleteDatabase(DbEconomicaOpenHelper.DATABASE_NAME);
        }
        @Test
        public void openBooksDbTest() {
           Context appContext = getContext();

            DbEconomicaOpenHelper dbEconomicaOpenHelper = new DbEconomicaOpenHelper(appContext);

            SQLiteDatabase db = dbEconomicaOpenHelper.getReadableDatabase();
            assertTrue("Could not open/create books database", db.isOpen());
            db.close();
        }

    @Test
    public void paisCRUDTest(){
        DbEconomicaOpenHelper dbEconomicaOpenHelper = new DbEconomicaOpenHelper(getContext());
        SQLiteDatabase db = dbEconomicaOpenHelper.getWritableDatabase();
        DbTabelaPais tabelaPais = new DbTabelaPais(db);

        Pais pais = new Pais();
        pais.setNome("Protugal");
        // Insert/create (C)RUD
        long id = insertPais(tabelaPais, pais);

        // query/read C(R)UD
        pais = ReadFirstPais(tabelaPais, "Protugal", id);
        // update CR(U)D
        pais.setNome("Portugal");
        int rowsAffected = tabelaPais.update(
                DbTabelaPais.getContentValues(pais),
                DbTabelaPais._ID + "=?",
                new String[]{Long.toString(id)}
        );
        assertEquals("Failed to update pais", 1, rowsAffected);
        // query/read C(R)UD
        pais = ReadFirstPais(tabelaPais, "Sci-fi", id);
        // delete CRU(D)
        rowsAffected = tabelaPais.delete(
                DbTabelaPais._ID + "=?",
                new String[]{Long.toString(id)}
        );
        assertEquals("Failed to delete pais", 1, rowsAffected);
        Cursor cursor = tabelaPais.quarry(DbTabelaPais.All_colunas, null, null,
                null, null, null);
        assertEquals("Pias found after delete = ??", 0, cursor.getCount());

    }


    @Nonnull
     private Pais ReadFirstPais(DbTabelaPais tablepais, String expectedName, long expectedId) {
            Cursor cursor = tablepais.quarry(DbTabelaPais.All_colunas, null, null,
                    null, null, null);
            assertEquals("Failed to read Pais", 1, cursor.getCount());

            assertTrue("Failed to read the first Pais", cursor.moveToNext());

            Pais pais = DbTabelaPais.getCurrentpais(cursor);
                assertEquals("Incorrect pais name", expectedName, pais.getNome());
                assertEquals("Incorrect pais id", expectedId, pais.getId());

        return pais;
     }


     @Test
     public void funcoesCRUDTest(){
         DbEconomicaOpenHelper dbEconomicaOpenHelper = new DbEconomicaOpenHelper(getContext());
         SQLiteDatabase db = dbEconomicaOpenHelper.getWritableDatabase();
         DbTabelaPais tabelaPais = new DbTabelaPais(db);
         Pais pais = new Pais();
         pais.setNome("Portugal");
         long idCategory = insertPais(tabelaPais, pais);
         DbTabelaFuncoes tabelaFuncoes = new DbTabelaFuncoes(db);
         // Insert/create (C)RUD
         Funcoes funcoes = new Funcoes();

         funcoes.setNome("Fuel");
         funcoes.setValor(15);
         funcoes.setIdpais((int) idCategory);
         long id = tabelaFuncoes.insert(
                 DbTabelaFuncoes.getContentValues(funcoes)
         );
         assertNotEquals("Failed to insert funcao", -1, id);
         // query/read C(R)UD
         funcoes = ReadFirstFuncao(tabelaFuncoes, 15, "Fuel", idCategory, id);

         // update CR(U)D
         funcoes.setNome("Fuel");
         funcoes.setValor(10.20);

         int rowsAffected = tabelaFuncoes.update(
                 DbTabelaFuncoes.getContentValues(funcoes),
                 DbTabelaFuncoes._ID + "=?",
                 new String[]{Long.toString(id)}
         );
         assertEquals("Failed to update funcao", 1, rowsAffected);

         // query/read C(R)UD
         funcoes = ReadFirstFuncao(tabelaFuncoes, 10.20, "Fuel", idCategory, id);

         // delete CRU(D)
         rowsAffected = tabelaFuncoes.delete(
                 DbTabelaFuncoes._ID + "=?",
                 new String[]{Long.toString(id)}
         );
         assertEquals("Failed to delete funcao", 1, rowsAffected);

         Cursor cursor = tabelaFuncoes.quarry(DbTabelaFuncoes.All_colunas, null, null,
                 null, null, null);
         assertEquals("Funcao found after delete = ??", 0, cursor.getCount());


    }

     @Nonnull
     private Funcoes ReadFirstFuncao(DbTabelaFuncoes tablefuncoes,double expectedNum,String expectedNome,
                                     long expectPaisID,long expectedID){
           Cursor cursor = tablefuncoes.quarry(DbTabelaFuncoes.All_colunas,null,null,null,null,null);
           assertEquals("Failed to read Funcao",cursor.getCount());
           assertTrue("Failed to read the first Funcao",cursor.moveToNext());

           Funcoes funcoes = DbTabelaFuncoes.getCurrentFuncoes(cursor);
           assertEquals("Incorrect funcao ID",expectedID,funcoes.getId());
           assertEquals("Incorrect funcao Name",expectedNome,funcoes.getNome());
           assertEquals("Incorrect funcao value",expectedNum,funcoes.getValor(),0.25);
            assertEquals("Incorrect funcao IDpais",expectPaisID,funcoes.getIdpais());

            return funcoes;
       }


        private Context getContext() {
            return InstrumentationRegistry.getTargetContext();
        }

    private long insertPais(DbTabelaPais tablepais, Pais category) {
        long id = tablepais.insert(
                DbTabelaPais.getContentValues(category)
        );

        assertNotEquals("Failed to insert a pais", -1, id);

        return id;
    }
}
