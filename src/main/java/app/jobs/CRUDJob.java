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
 * Tarefa Agendada CRUD
 *
 * teste
 */
@Component
@DisallowConcurrentExecution
public class CRUDJob implements Job {

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    try {
      //teste
      blockly.CRUD.Inserir();
    } catch (Exception e) {
      throw new JobExecutionException(e);
    }
  }

  @Bean(name = "cRUDJobDetail")
  public JobDetailFactoryBean cRUDJobDetail() {
    return SchedulerConfigurer.createJobDetail(this.getClass());
  }

  /**
   * teste
   * 25 segundos depois do minuto
   */
  @Bean(name = "cRUDJobTesteTrigger")
  public CronTriggerFactoryBean cRUDJobTesteTrigger(@Qualifier("cRUDJobDetail") JobDetail jobDetail) {

    return SchedulerConfigurer.createCronTrigger(jobDetail, "25 * * * * ?");
  }
}