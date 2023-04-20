package net.prasenjit.poc.library.core.rest;

import net.prasenjit.poc.library.core.RestClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RestClientRegisterer implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false){
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                return false;
            }
        };
        scanner.addIncludeFilter(new AnnotationTypeFilter(RestClient.class));
        Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents("net.prasenjit.poc");
        for (BeanDefinition candidateComponent : candidateComponents) {

        }
    }
}
