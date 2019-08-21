package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class PaiDelete {

public static final int TIMEOUT = 300;

/**
 *
 * @param param_id_pai
 * @return Var
 */
// PaiDelete
public static Var Executar(Var param_id_pai) throws Exception {
 return new Callable<Var>() {

   // param
   private Var id_pai = param_id_pai;
   // end
   private Var item = Var.VAR_NULL;
   private Var id_neto = Var.VAR_NULL;

   public Var call() throws Exception {
    id_pai = id_pai;
    System.out.println(id_pai.getObjectAsString());
    item = cronapi.database.Operations.query(Var.valueOf("app.entity.Neto"),Var.valueOf("select n from Neto n where n.pai.id = :paiId"),Var.valueOf("paiId",id_pai));
    System.out.println(item.getObjectAsString());
    if (cronapi.logic.Operations.isNullOrEmpty(item).negate().getObjectAsBoolean()) {
        id_neto = cronapi.object.Operations.getObjectField(item, Var.valueOf("id"));
        System.out.println(id_neto.getObjectAsString());
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Neto"), Var.valueOf("delete from Neto where id = :id"),Var.valueOf("id",id_neto));
        id_pai = cronapi.object.Operations.getObjectField(item, Var.valueOf("pai.id"));
        System.out.println(id_pai.getObjectAsString());
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Pai"), Var.valueOf("delete from Pai where id = :id"),Var.valueOf("id",id_pai));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("Pai"), Var.valueOf("false"));
    } else {
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Pai"), Var.valueOf("delete from Pai where id = :id"),Var.valueOf("id",id_pai));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("Pai"), Var.valueOf("false"));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

