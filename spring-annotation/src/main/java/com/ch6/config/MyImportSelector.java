package com.ch6.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义返回多个组件的全类名(数组)
 * 需要实现ImportSelector
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        /**
         * 这里不能返回null,会报空指针。
         * 调用返回的数组.length
         * 可以返回空数组
         */
        //return null;
        //return new String[]{};
        return new String[]{"com.ch6.bean.Fish", "com.ch6.bean.Tiger"};

    }
}
