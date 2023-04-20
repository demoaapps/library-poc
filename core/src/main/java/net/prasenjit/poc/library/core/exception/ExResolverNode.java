package net.prasenjit.poc.library.core.exception;

import lombok.Getter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ExResolverNode extends TreeNode<ExResolver<?>> {
    @Getter
    private final Class handlerClass;

    public ExResolverNode(ExResolver<?> data) {
        super(data, null);
        this.handlerClass = findHandlerClass(data.getClass());
    }

    private Class findHandlerClass(Class<? extends ExResolver> aClass) {
        Type[] genericSuperclass = aClass.getGenericInterfaces();
        for (Type superclass : genericSuperclass) {
            ParameterizedType parameterizedType = ((ParameterizedType) superclass);
            if (parameterizedType.getRawType().equals(ExResolver.class)) {
                return (Class) parameterizedType.getActualTypeArguments()[0];
            }
        }
        return null;
    }

    @Override
    public void addChild(ExResolver<?> childData) {
        Class newClass = findHandlerClass(childData.getClass());
        if (handlerClass.equals(newClass)){
            return;
        } else {
            for (TreeNode<ExResolver<?>> child : getChildren()) {
//                child.get
            }
        }
        super.addChild(childData);
    }
}
