package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Cascata {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Cascata
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var id_neto = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var id_pai = Var.VAR_NULL;
   private Var k = Var.VAR_NULL;
   private Var id_avo = Var.VAR_NULL;

   public Var call() throws Exception {
    item = cronapi.database.Operations.query(Var.valueOf("app.entity.Neto"),Var.valueOf("select n from Neto n"));
    if (cronapi.database.Operations.hasElement(item).getObjectAsBoolean()) {
        for (Iterator it_i = item.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            id_neto = cronapi.object.Operations.getObjectField(i, Var.valueOf("id"));
            System.out.println(id_neto.getObjectAsString());
            cronapi.database.Operations.execute(Var.valueOf("app.entity.Neto"), Var.valueOf("delete from Neto where id = :id"),Var.valueOf("id",id_neto));
        } // end for
        for (Iterator it_j = item.iterator(); it_j.hasNext();) {
            j = Var.valueOf(it_j.next());
            id_pai = cronapi.object.Operations.getObjectField(j, Var.valueOf("pai.id"));
            System.out.println(id_pai.getObjectAsString());
            cronapi.database.Operations.execute(Var.valueOf("app.entity.Pai"), Var.valueOf("delete from Pai where id = :id"),Var.valueOf("id",id_pai));
        } // end for
        for (Iterator it_k = item.iterator(); it_k.hasNext();) {
            k = Var.valueOf(it_k.next());
            id_avo = cronapi.object.Operations.getObjectField(k, Var.valueOf("pai.avo.id"));
            System.out.println(id_avo.getObjectAsString());
            cronapi.database.Operations.execute(Var.valueOf("app.entity.Avo"), Var.valueOf("delete from Avo where id = :id"),Var.valueOf("id",id_avo));
        } // end for
    }
    System.out.println(Var.valueOf("abc").getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

}

