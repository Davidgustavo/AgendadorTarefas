package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CRUD {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// CRUD
public static Var Inserir() throws Exception {
 return new Callable<Var>() {

   private Var inserir = Var.VAR_NULL;

   public Var call() throws Exception {
    inserir = inserir;
    cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),Var.valueOf("password",Var.valueOf("teste")),Var.valueOf("name",Var.valueOf("teste")),Var.valueOf("login",Var.valueOf("teste")),Var.valueOf("email",Var.valueOf("teste")));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("User"), Var.valueOf("false"));
    System.out.println(Var.valueOf("Teste").getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var Delete() throws Exception {
 return new Callable<Var>() {

   private Var delete = Var.VAR_NULL;

   public Var call() throws Exception {
    delete = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.id from User u where u.login = :login"),Var.valueOf("login",Var.valueOf("teste")));
    delete = cronapi.list.Operations.getFirst(delete);
    System.out.println(delete.getObjectAsString());
    cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("delete from User where id = :id"),Var.valueOf("id",delete));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("User"), Var.valueOf("false"));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var Update() throws Exception {
 return new Callable<Var>() {

   private Var update = Var.VAR_NULL;

   public Var call() throws Exception {
    update = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.id from User u where u.login = :login"),Var.valueOf("login",Var.valueOf("teste")));
    update = cronapi.list.Operations.getFirst(update);
    System.out.println(update.getObjectAsString());
    cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update User set email = :email where id = :id"),Var.valueOf("email",Var.valueOf("teste1")),Var.valueOf("id",update));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("User"), Var.valueOf("true"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

