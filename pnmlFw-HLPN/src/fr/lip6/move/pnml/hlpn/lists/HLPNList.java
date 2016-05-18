/**
 *  Copyright 2009-2016 Université Paris Ouest and Sorbonne Universités,
 * 							Univ. Paris 06 - CNRS UMR 7606 (LIP6)
 *
 *  All rights reserved.   This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Project leader / Initial Contributor:
 *    Lom Messan Hillah - <lom-messan.hillah@lip6.fr>
 *
 *  Contributors:
 *    ${ocontributors} - <$oemails}>
 *
 *  Mailing list:
 *    lom-messan.hillah@lip6.fr
 */
/**
 * (C) Sorbonne Universités, UPMC Univ Paris 06, UMR CNRS 7606 (LIP6/MoVe)
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *    Lom HILLAH (LIP6) - Initial models and implementation
 *    Rachid Alahyane (UPMC) - Infrastructure and continuous integration
 *    Bastien Bouzerau (UPMC) - Architecture 
 *    Guillaume Giffo (UPMC) - Code generation refactoring, High-level API
 */
package fr.lip6.move.pnml.hlpn.lists;

import java.nio.channels.FileChannel;

import org.apache.axiom.om.OMElement;
import org.eclipse.emf.common.util.DiagnosticChain;

import fr.lip6.move.pnml.framework.utils.IdRefLinker;
import fr.lip6.move.pnml.framework.utils.exception.InnerBuildException;
import fr.lip6.move.pnml.framework.utils.exception.InvalidIDException;
import fr.lip6.move.pnml.framework.utils.exception.VoidRepositoryException;
import fr.lip6.move.pnml.hlpn.terms.BuiltInSort;
import fr.lip6.move.pnml.hlpn.terms.Sort;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HLPN List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.lip6.move.pnml.hlpn.lists.HLPNList#getBasis <em>Basis</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lip6.move.pnml.hlpn.lists.ListsPackage#getHLPNList()
 * @model annotation="http://www.pnml.org/models/ToPNML tag='list' kind='son'"
 *        annotation="http://www.pnml.org/models/methods/SORT signature='boolean equalSorts(Sort sort)' body='boolean isEqual = false;\n\t\tif (this.eClass().getName().equalsIgnoreCase(sort.eClass().getName())) {\n\t\t\tif (this.getContainerNamedSort() != null\n\t\t\t\t\t&& sort.getContainerNamedSort() != null) {\n\t\t\t\tisEqual = this.getContainerNamedSort().getName()\n\t\t\t\t\t\t.equalsIgnoreCase(\n\t\t\t\t\t\t\t\tsort.getContainerNamedSort().getName());\n\t\t\t} else {\n\t\t\t\t//further sub-classes must override this method.\n\t\t\t\tif (\"HLPNList\".equalsIgnoreCase(this.eClass().getName())) {\n\t\t\t\t\tHLPNList myList = (HLPNList) this;\n\t\t\t\t\tHLPNList thatList = (HLPNList) sort;\n\t\t\t\t\tif (myList.getBasis() instanceof UserSort\n\t\t\t\t\t    && thatList.getBasis() instanceof UserSort) { \n\t\t\t\t\t\tisEqual =  ((UserSort) myList.getBasis()).getDeclaration().getName()\n\t\t\t\t\t\t\t.equalsIgnoreCase(\n\t\t\t\t\t\t\t\t\t((UserSort) thatList.getBasis()).getDeclaration()\n\t\t\t\t\t\t\t\t\t\t\t.getName());\n\t\t\t\t    }\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn isEqual;' documentation='/**\r * Returns true if this sort and argument sort are actually \r * semantically the same sort, even in two different objects.\r * Ex: two FiniteEnumerations or two Integers.\r * @return true if so. \r * @param sort the sort to which we compare this one. \r \052/'"
 * @generated
 */
public interface HLPNList extends BuiltInSort {
	/**
	 * Returns the value of the '<em><b>Basis</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link fr.lip6.move.pnml.hlpn.terms.Sort#getContainerList <em>Container List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basis</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basis</em>' containment reference.
	 * @see #setBasis(Sort)
	 * @see fr.lip6.move.pnml.hlpn.lists.ListsPackage#getHLPNList_Basis()
	 * @see fr.lip6.move.pnml.hlpn.terms.Sort#getContainerList
	 * @model opposite="containerList" containment="true" required="true"
	 *        annotation="http://www.pnml.org/models/ToPNML kind='follow'"
	 * @generated
	 */
	Sort getBasis();

	/**
	 * Sets the value of the '{@link fr.lip6.move.pnml.hlpn.lists.HLPNList#getBasis <em>Basis</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis</em>' containment reference.
	 * @see #getBasis()
	 * @generated
	 */
	void setBasis(Sort value);

	/**
	 * Return the string containing the pnml output
	 */
	@Override
	public String toPNML();

	/**
	 * set values to conform PNML document
	 */
	@Override
	public void fromPNML(OMElement subRoot, IdRefLinker idr) throws InnerBuildException, InvalidIDException,
			VoidRepositoryException;

	/**
	 * Write the PNML xml tree of this object into file
	 */
	@Override
	public void toPNML(FileChannel fc);

	@Override
	public boolean validateOCL(DiagnosticChain diagnostics);
} // HLPNList
