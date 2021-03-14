/**
 */
package repository;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The PCM is prepared to support interface protocols. This package contains a protocol stub. Multiple protocols following
 * different formalisms are supported by the PCM and distinguished by a protocol ID.
 * 
 * A protocol is a set of calling sequences and can be optionally added to an interface. Protocols of provided
 * interfaces specify the order in which services have to be called by clients. Protocols of required interfaces
 * specify the actual order in which the component calls required services.
 * 
 * Besides finite state machines, different formalisms can be used to model protocols. The PCM does
 * not restrict the protocol modelling formalisms. For example, Petri nets or regular expressions could
 * model interface protocols. However, the choice of a formalism does influence possible analyses. For
 * example, to check the interoperability of two components A and B, the language inclusion of the required
 * protocol of A within the provided protocol of B has to be tested. The language inclusion is undecidable for
 * Petri nets in the general case, so protocols modelled with Petri nets cannot be checked for interoperability.
 * Notice, that although protocols are able to express the state of a component, interfaces themselves
 * are stateless. The protocol state only depends on the component that implements the interface and is only
 * present during component runtime. Components can provide/require multiple interfaces, but the PCM
 * does not support protocols ranging over multiple interfaces (neither for provided nor required protocols).
 * The complete state of a components consists of all its interface states. Restrictions on the complete state
 * cannot be expressed in the PCM, as protocols can only be specified for single interfaces.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link repository.Protocol#getProtocolTypeID <em>Protocol Type ID</em>}</li>
 * </ul>
 *
 * @see repository.RepositoryPackage#getProtocol()
 * @model abstract="true"
 * @generated
 */
public interface Protocol extends EObject {
	/**
	 * Returns the value of the '<em><b>Protocol Type ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Multiple protocols following different formalisms are supported by the PCM and distinguished by a protocol ID.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protocol Type ID</em>' attribute.
	 * @see #setProtocolTypeID(String)
	 * @see repository.RepositoryPackage#getProtocol_ProtocolTypeID()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getProtocolTypeID();

	/**
	 * Sets the value of the '{@link repository.Protocol#getProtocolTypeID <em>Protocol Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol Type ID</em>' attribute.
	 * @see #getProtocolTypeID()
	 * @generated
	 */
	void setProtocolTypeID(String value);

} // Protocol
