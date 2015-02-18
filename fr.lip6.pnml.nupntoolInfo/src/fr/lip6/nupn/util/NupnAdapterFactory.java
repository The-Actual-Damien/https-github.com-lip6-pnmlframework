/**
 */
package fr.lip6.nupn.util;

import fr.lip6.nupn.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.lip6.nupn.NupnPackage
 * @generated
 */
public class NupnAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NupnPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NupnAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = NupnPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NupnSwitch<Adapter> modelSwitch = new NupnSwitch<Adapter>() {
		@Override
		public Adapter caseSizeType(SizeType object) {
			return createSizeTypeAdapter();
		}

		@Override
		public Adapter caseStructureType(StructureType object) {
			return createStructureTypeAdapter();
		}

		@Override
		public Adapter caseNUPNToolspecificType(NUPNToolspecificType object) {
			return createNUPNToolspecificTypeAdapter();
		}

		@Override
		public Adapter caseUnitType(UnitType object) {
			return createUnitTypeAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lip6.nupn.SizeType <em>Size Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lip6.nupn.SizeType
	 * @generated
	 */
	public Adapter createSizeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lip6.nupn.StructureType <em>Structure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lip6.nupn.StructureType
	 * @generated
	 */
	public Adapter createStructureTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lip6.nupn.NUPNToolspecificType <em>NUPN Toolspecific Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lip6.nupn.NUPNToolspecificType
	 * @generated
	 */
	public Adapter createNUPNToolspecificTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lip6.nupn.UnitType <em>Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lip6.nupn.UnitType
	 * @generated
	 */
	public Adapter createUnitTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //NupnAdapterFactory
