package com.company.springMySQL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.entityBeans.Marca;
import com.company.service.IServiceMarca;

/**
<!--
		Spring Framework Tutorial - 25 MySQL
 		https://www.youtube.com/watch?v=hinfBLVsqF4&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb
-->
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring Framework Tutorial - 25 MySQL" );
        Marca marca = new Marca();
        marca.setId(2);
        marca.setNombre("Puma");
        
        
        String configLocation = "com/company/xml/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        //Marca marcaPajarito = BeanDefaultPruebasParaRegistrar(applicationContext);


        // https://www.youtube.com/watch?v=hinfBLVsqF4&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=1296s
        //Objeto[Marca] se pasa a:    CapaServicios -> CapaRepositoryDao
        IServiceMarca iServiceMarca = (IServiceMarca) applicationContext.getBean("serviceMarcaImpl");

        try {
			iServiceMarca.registrar(marca);
			//iServiceMarca.registrar(marcaPajarito);
		} catch (Exception e) {
			System.err.println("ERROR :#  :" + e.getMessage());
			e.printStackTrace();
		}

        System.out.println("OK!!");
        ((ConfigurableApplicationContext) applicationContext).close();
    }
    
    public static Marca BeanDefaultPruebasParaRegistrar(ApplicationContext applicationContext ) {
    	return (Marca) applicationContext.getBean("BEAN_MarcaID");
    }
}
