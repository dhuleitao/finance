package service;

import java.util.List;

import entity.Finfailed;
import entity.Finsuccess;


public interface FinsuccessAdminDAO {
	public List<Finsuccess> queryAllFinsuccess();
	public List<Finfailed> queryAllFinfail();
	public List<Finfailed> queryAllFining();
	public Finsuccess queryFinsuccessBySid(String sid);
	
	public boolean addFinsuccess(Finsuccess s);
	
	public boolean updateFinsuccess(Finsuccess s);
	public boolean move(String srcTbl, String fid, String desTbl);
	public boolean savesuccess(Finsuccess s);
	public boolean movee(String srcTbl, String fid, String comment,String desTbl);
	boolean finIt(String srcTbl, String fid, String desTbl);
}
