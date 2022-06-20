package hw.ch05.framework;

import ch04.Sample.framework.FactoryMethodRuntimeException;

public abstract class Factory {
	// 물건 만들고, 등록하는 일을 하는 메소드 (템플릿메소드이다)
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

	// 하위 클래스(구체적인 공장)에서 구현하는 메소드들
    //protected abstract Product createProduct(String owner);
    protected Product createProduct(String owner) throws FactoryMethodRuntimeException {
    	throw new FactoryMethodRuntimeException();
    }
    protected abstract void registerProduct(Product product);
}
