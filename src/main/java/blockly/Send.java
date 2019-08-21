package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Send {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Send
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.email.Operations.sendEmail(Var.valueOf("david.alves@cronapp.io"), Var.valueOf("guga.lite@hotmail.com"), Var.VAR_NULL, Var.VAR_NULL, Var.valueOf("Teste2 Cronapp"), Var.valueOf("Teste Cronapp"), Var.valueOf("<h1> texto grande </h1>"), Var.VAR_NULL, Var.valueOf("smtp.office365.com"), Var.valueOf("587"), Var.valueOf("david.alves@cronapp.io"), Var.valueOf("714280C!ntia"), Var.valueOf("TLS"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

