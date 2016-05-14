package com.proyin.contratos;

import java.util.List;
import com.proyin.adaptadores.*;

public interface IDAO {

	/** 
	 * @param  IDTO Cualquier clase que implemente la interface IDTO
	 * @return      Retorna true si se inserto correctamente, false si hubo error en el registro
	 */
	public boolean insert(IDTO dto) throws Exception;
	/**
	 * @param  IDTO Cualquier clase que implemente la interface IDTO
	 * @return      Retorna true si se actualizó correctamente, false si hubo error en la actualizacion
	 */
	public boolean update(IDTO dto) throws Exception;
	/** 
	 * @param  IDTO Cualquier clase que implemente la interface IDTO
	 * @return      Retorna true si se eliminó correctamente, false si hubo error en la eliminación
	 */
	public boolean delete(IDTO dto) throws Exception;
	/** 
	 * @param  IDTO Cualquier clase que implemente la interface IDTO
	 * @return      Retorna una lista de objetos IDTO
	 */
	public List<IDTO> getAll() throws Exception;
	/** 
	 * @param  IDTO Cualquier clase que implemente la interface IDTO
	 * @return      Retorna un objeto IDTO
	 */
	public IDTO getById(int id) throws Exception;
}
