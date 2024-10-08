package tech.jhipster.lite.generator.server.springboot.database.mariadb.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.JPA_PERSISTENCE;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.MARIADB;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.SPRING_BOOT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.database.mariadb.application.MariaDBApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class MariaDBModuleConfiguration {

  @Bean
  JHipsterModuleResource mariaDBModule(MariaDBApplicationService applicationService) {
    return JHipsterModuleResource.builder()
      .slug(MARIADB)
      .propertiesDefinition(
        JHipsterModulePropertiesDefinition.builder()
          .addBasePackage()
          .addIndentation()
          .addProjectBaseName()
          .addSpringConfigurationFormat()
          .build()
      )
      .apiDoc("Spring Boot - Database", "Add MariaDB to project")
      .organization(JHipsterModuleOrganization.builder().feature(JPA_PERSISTENCE).addDependency(SPRING_BOOT).build())
      .tags("server", "spring", "spring-boot", "database")
      .factory(applicationService::build);
  }
}
