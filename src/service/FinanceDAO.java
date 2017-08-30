package service;

import java.util.List;

import entity.Financing;
import entity.Fincanceled;
import entity.Finfailed;

public interface FinanceDAO {
	public boolean addFinance(Financing f);

	Object query(String hql);

	public boolean move(Object delF, Object addF);

}
