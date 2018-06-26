package com.example.andre.calculadoraandroid;

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
            assertTrue("Não foi possível criar/abrir a base de dados", db.isOpen());
            db.close();
        }

    @Test
    public void paisCRUDTest(){
        DbEconomicaOpenHelper dbEconomicaOpenHelper = new DbEconomicaOpenHelper(getContext());
        SQLiteDatabase db = dbEconomicaOpenHelper.getWritableDatabase();
        DbTabelaFinancas tabelaPais = new DbTabelaFinancas(db);

        Financas Financas = new Financas();
        Financas.setNome("Financa");
        // Insert/create (C)RUD
        long id = insertPais(tabelaPais, Financas);

        // query/read C(R)UD
        Financas = ReadFirstFinanca(tabelaPais, "Financa", id);
        // update CR(U)D
        Financas.setNome("Financa");
        int rowsAffected = tabelaPais.update(
                DbTabelaFinancas.getContentValues(Financas),
                DbTabelaFinancas._ID + "=?",
                new String[]{Long.toString(id)}
        );
        assertEquals("Falha no update de financa", 1, rowsAffected);
        // query/read C(R)UD
        Financas = ReadFirstFinanca(tabelaPais, "Financa", id);
        // delete CRU(D)
        rowsAffected = tabelaPais.delete(
                DbTabelaFinancas._ID + "=?",
                new String[]{Long.toString(id)}
        );
        assertEquals("Falha no delete de Financa", 1, rowsAffected);
        Cursor cursor = tabelaPais.quarry(DbTabelaFinancas.All_colunas, null, null,
                null, null, null);
        assertEquals("Financa encontra apos delete = ??", 0, cursor.getCount());

    }


    @Nonnull
     private Financas ReadFirstFinanca(DbTabelaFinancas tablepais, String expectedName, long expectedId) {
            Cursor cursor = tablepais.quarry(DbTabelaFinancas.All_colunas, null, null,
                    null, null, null);
            assertEquals("Falha ao ler Financa", 4, cursor.getCount());

            assertTrue("Falha ao ler a primeira Financa", cursor.moveToNext());

            Financas Financas = DbTabelaFinancas.getCurrentpais(cursor);
                assertEquals("Nome de Financa Incorreta", expectedName, Financas.getNome());
                assertEquals("ID Financa incorreta", expectedId, Financas.getId());

        return Financas;
     }


     @Test
     public void funcoesCRUDTest(){
         DbEconomicaOpenHelper dbEconomicaOpenHelper = new DbEconomicaOpenHelper(getContext());
         SQLiteDatabase db = dbEconomicaOpenHelper.getWritableDatabase();
         DbTabelaFinancas tabelaFinancas = new DbTabelaFinancas(db);
         Financas Financas = new Financas();
         Financas.setNome("Financa");
         long idPais = insertPais(tabelaFinancas, Financas);
         DbTabelaFuncoes tabelaFuncoes = new DbTabelaFuncoes(db);
         // Insert/create (C)RUD
         Funcoes funcoes = new Funcoes();

         funcoes.setNome("Combustivel");
         funcoes.setValor(15);
         funcoes.setIdFinanca((int) idPais);
         long id = tabelaFuncoes.insert(
                 DbTabelaFuncoes.getContentValues(funcoes)
         );
         assertNotEquals("Falha de insercao de Funcao", -1, id);
         // query/read C(R)UD
         funcoes = ReadFirstFuncao(tabelaFuncoes, 15, "Combustivel", idPais, id);

         // update CR(U)D
         funcoes.setNome("Combustivel");
         funcoes.setValor(10.20);

         int rowsAffected = tabelaFuncoes.update(
                 DbTabelaFuncoes.getContentValues(funcoes),
                 DbTabelaFuncoes._ID + "=?",
                 new String[]{Long.toString(id)}
         );
         assertEquals("Falha a dar update a Funcao", 1, rowsAffected);

         // query/read C(R)UD
         funcoes = ReadFirstFuncao(tabelaFuncoes, 10.20, "Combustivel", idPais, id);

         // delete CRU(D)
         rowsAffected = tabelaFuncoes.delete(
                 DbTabelaFuncoes._ID + "=?",
                 new String[]{Long.toString(id)}
         );
         assertEquals("Falha ao apagar Funcao", 1, rowsAffected);

         Cursor cursor = tabelaFuncoes.quarry(DbTabelaFuncoes.All_colunas, null, null,
                 null, null, null);
         assertEquals("Funcao encontradas apos delete = ??", 0, cursor.getCount());


    }

     @Nonnull
     private Funcoes ReadFirstFuncao(DbTabelaFuncoes tablefuncoes,double expectedNum,String expectedNome,
                                     long expectPaisID,long expectedID){
           Cursor cursor = tablefuncoes.quarry(DbTabelaFuncoes.All_colunas,null,null,
                   null,null,null);
           assertEquals("Falha ao ler Funcao",4,cursor.getCount());
           assertTrue("Erro ao ler a primeira funcao",cursor.moveToNext());

           Funcoes funcoes = DbTabelaFuncoes.getCurrentFuncoes(cursor);
           assertEquals("Id funcao incorreta",expectedID,funcoes.getId());
           assertEquals("Nome de funcao Incorreta",expectedNome,funcoes.getNome());
           assertEquals("Funcao valor incorreta",expectedNum,funcoes.getValor(),0.25);
            assertEquals("Funcao IDFinanca incorreta",expectPaisID,funcoes.getIdFinanca());

            return funcoes;
       }


        private Context getContext() {
            return InstrumentationRegistry.getTargetContext();
        }

    private long insertPais(DbTabelaFinancas tablepais, Financas category) {
        long id = tablepais.insert(
                DbTabelaFinancas.getContentValues(category)
        );

        assertNotEquals("Impossível inserir a Financa", -1, id);

        return id;
    }
}
