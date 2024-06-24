package dao;

import java.util.ArrayList;

import model.NhanVienModel;

public class NhanvienDAO implements DAOinterface<NhanVienModel>{

	public NhanvienDAO getInstance() {
		return new NhanvienDAO();
	}
	
	
	@Override
	public int insert(NhanVienModel t) {

		return 0;
	}

	@Override
	public int update(NhanVienModel t) {

		return 0;
	}

	@Override
	public int delete(NhanVienModel t) {

		return 0;
	}

	@Override
	public ArrayList<NhanVienModel> selectAll() {

		return null;
	}

	@Override
	public NhanVienModel selectById(NhanVienModel t) {

		return null;
	}

	@Override
	public ArrayList<NhanVienModel> selectByCondition(String condition) {

		return null;
	}

	
	
}
