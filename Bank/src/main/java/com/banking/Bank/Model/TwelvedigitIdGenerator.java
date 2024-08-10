package com.banking.Bank.Model;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TwelvedigitIdGenerator  implements IdentifierGenerator{

	/**
	 * 
	 */

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object)  {
Random random = new Random();
        
       Long number;
       do {
           number = (long)(Math.pow(10,11)+random.nextDouble() * 9 * Math.pow(10,11));
           }
       while(number < Math.pow(10,11));
       
        return number;
}
}


