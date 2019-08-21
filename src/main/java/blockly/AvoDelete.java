package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AvoDelete {

public static final int TIMEOUT = 300;

/**
 *
 * @param param_id_avo
 * @return Var
 */
// AvoDelete
public static Var Executar(Var param_id_avo) throws Exception {
 return new Callable<Var>() {

   // param
   private Var id_avo = param_id_avo;
   // end
   private Var item = Var.VAR_NULL;
   private Var id_neto = Var.VAR_NULL;
   private Var id_pai = Var.VAR_NULL;

   public Var call() throws Exception {
    id_avo = id_avo;
    System.out.println(id_avo.getObjectAsString());
    item = cronapi.database.Operations.query(Var.valueOf("app.entity.Neto"),Var.valueOf("select n from Neto n where n.pai.avo.id = :paiAvoId"),Var.valueOf("paiAvoId",id_avo));
    System.out.println(item.getObjectAsString());
    if (cronapi.logic.Operations.isNullOrEmpty(item).negate().getObjectAsBoolean()) {
        id_neto = cronapi.object.Operations.getObjectField(item, Var.valueOf("id"));
        System.out.println(id_neto.getObjectAsString());
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Neto"), Var.valueOf("delete from Neto where id = :id"),Var.valueOf("id",id_neto));
        id_pai = cronapi.object.Operations.getObjectField(item, Var.valueOf("pai.id"));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Pai"), Var.valueOf("delete from Pai where id = :id"),Var.valueOf("id",id_pai));
        System.out.println(id_pai.getObjectAsString());
        id_avo = cronapi.object.Operations.getObjectField(item, Var.valueOf("pai.avo.id"));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Avo"), Var.valueOf("delete from Avo where id = :id"),Var.valueOf("id",id_avo));
        System.out.println(id_avo.getObjectAsString());
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("Avo"), Var.valueOf("false"));
    } else {
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Avo"), Var.valueOf("delete from Avo where id = :id"),Var.valueOf("id",id_avo));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("Avo"), Var.valueOf("false"));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

