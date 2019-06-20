package customize.handler;

import customize.parser.UserBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/***
 * 创建一个Handler类，扩展自NamespaceHandlerSupport，目的是将组件注册到spring容器中。
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
        registerBeanDefinitionParser("A", new UserBeanDefinitionParser());
        registerBeanDefinitionParser("B", new UserBeanDefinitionParser());
    }
}
