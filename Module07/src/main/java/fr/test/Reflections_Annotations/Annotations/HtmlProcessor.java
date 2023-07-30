package fr.test.Reflections_Annotations.Annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("HtmlInput")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class HtmlProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            Set<? extends TypeElement> annotatedElements =  (Set<? extends TypeElement>) roundEnv.getElementsAnnotatedWith(annotation);
            for (TypeElement element : annotatedElements) {
                try {
                    String className = element.getSimpleName().toString() + "ToString";
                    String packageName = processingEnv.getElementUtils().getPackageOf(element).toString();
                    String generatedClassName = packageName + "." + className;

                    generateToStringMethod(generatedClassName, element.getSimpleName().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

}
