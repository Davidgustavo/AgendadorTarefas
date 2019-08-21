/**
 * As alterações neste arquivo podem causar um comportamento incorreto e serão
 * perdidas se a IDE precisar atualizá-lo
 */
package app.jobs;

import cronapp.framework.scheduler.SchedulerConfigurer;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import cronapi.Var;

/**
 * Tarefa Agendada Inserte
 *
 * insere no banco
 */
@Component
@DisallowConcurrentExecution
public class InserteJob implements Job {

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    try {
      //insere
      blockly.CRUD.Inserir();
    } catch (Exception e) {
      throw new JobExecutionException(e);
    }
  }

  @Bean(name = "inserteJobDetail")
  public JobDetailFactoryBean inserteJobDetail() {
    return SchedulerConfigurer.createJobDetail(this.getClass());
  }

  /**
   * insere
   * A cada minuto
   */
  @Bean(name = "inserteJobInsereTrigger")
  public CronTriggerFactoryBean inserteJobInsereTrigger(@Qualifier("inserteJobDetail") JobDetail jobDetail) {

    return SchedulerConfigurer.createCronTrigger(jobDetail, "0 */1 * * * ?");
  }
}