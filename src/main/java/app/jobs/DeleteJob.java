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
 * Tarefa Agendada delete
 *
 * remove 
 */
@Component
@DisallowConcurrentExecution
public class DeleteJob implements Job {

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    try {
      //delete
      blockly.CRUD.Delete();
    } catch (Exception e) {
      throw new JobExecutionException(e);
    }
  }

  @Bean(name = "deleteJobDetail")
  public JobDetailFactoryBean deleteJobDetail() {
    return SchedulerConfigurer.createJobDetail(this.getClass());
  }

  /**
   * delete
   * 10 segundos depois do minuto
   */
  @Bean(name = "deleteJobDeleteTrigger")
  public CronTriggerFactoryBean deleteJobDeleteTrigger(@Qualifier("deleteJobDetail") JobDetail jobDetail) {

    return SchedulerConfigurer.createCronTrigger(jobDetail, "10 */1 * * * ?");
  }
}