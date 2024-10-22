package com.shridhar.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.drools.decisiontable.DecisionTableProviderImpl;
import org.drools.drl.extensions.DecisionTableProvider;
import org.kie.api.KieServices;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DroolsConfig {
    public static final Logger LOGGER = LogManager.getLogger(DroolsConfig.class);
    private static final KieServices KIE_SERVICES = KieServices.Factory.get();

    public static final List<String> RULES_FILES_PATH_LIST = List.of("rules/drl/rules.drl",
            "rules/single/rules1-that-return-single-item.drl.xlsx",
            "com/rules/applicant-risk-ruleset.drl.xlsx",
            "rules/single/rules-that-return-single-item-with-subObject.drl.xlsx",
            "rules/list/rules-that-return-list.drl.xlsx");
    public static final List<String> EXCEL_FILE_EXTENSION_LIST = List.of(".xls", ".xlsx");

    @Bean
    public KieContainer kieContainer() {
        var kieFileSystem = KIE_SERVICES.newKieFileSystem();
        for (var path : RULES_FILES_PATH_LIST) {
            var resource = ResourceFactory.newClassPathResource(path, getClass());
            if (EXCEL_FILE_EXTENSION_LIST.stream().anyMatch(path::endsWith)) {
                printDecisionTable(path, resource);
            }
            kieFileSystem.write(resource);
        }
        var kieBuilder = KIE_SERVICES.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        var kieModule = kieBuilder.getKieModule();
        return KIE_SERVICES.newKieContainer(kieModule.getReleaseId());
    }

    private void printDecisionTable(String path, Resource resource) {
        DecisionTableConfiguration configuration = KnowledgeBuilderFactory.newDecisionTableConfiguration();
        configuration.setInputType(DecisionTableInputType.XLS);
        DecisionTableProvider decisionTableProvider = new DecisionTableProviderImpl();
        String drl = decisionTableProvider.loadFromResource(resource, configuration);
        LOGGER.info("drl conversion of decision table in excel - {}: \n{}", path, drl);

    }
}
