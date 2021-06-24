package com.nt.jai.ascept;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TxService {

	@Pointcut("execution(public String com.nt.jai.dao.EmployeeDao.saveEmployee())")
	public void p1() {}
	
	@Before("p1()")
	public void beginTx() {
		System.out.println("Tx Started!!");
	}
	@AfterReturning(value = "p1()", returning = "ob")
	public void commitTx(Object ob) {
		System.out.println("Tx is committed" + ob);
	}
	@AfterThrowing(value = "p1()",throwing = "th")
	public void rollbackTx(Throwable th) {
		System.out.println("Tx is rollback." + th.getMessage());
	}
	@After("p1()")
	public void sendReport() {
		System.out.println("Report sent!");
	}
}
