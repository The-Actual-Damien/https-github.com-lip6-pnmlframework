/**
 *  Copyright 2009-2015 Université Paris Ouest and Sorbonne Universités,
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
 *
 * $Id ggiffo, Tue Dec 23 11:30:48 CET 2014$
 */
package fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi;

import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.AnySort;
import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.ArbitraryOperator;
import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.ArbitrarySort;
import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.Unparsed;

import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.impl.ArbitrarydeclarationsFactoryImpl;

import fr.lip6.move.pnml.hlpn.booleans.And;
import fr.lip6.move.pnml.hlpn.booleans.Bool;
import fr.lip6.move.pnml.hlpn.booleans.BooleanConstant;
import fr.lip6.move.pnml.hlpn.booleans.Equality;
import fr.lip6.move.pnml.hlpn.booleans.Imply;
import fr.lip6.move.pnml.hlpn.booleans.Inequality;
import fr.lip6.move.pnml.hlpn.booleans.Not;
import fr.lip6.move.pnml.hlpn.booleans.Or;

import fr.lip6.move.pnml.hlpn.booleans.impl.BooleansFactoryImpl;

import fr.lip6.move.pnml.hlpn.cyclicEnumerations.CyclicEnumeration;
import fr.lip6.move.pnml.hlpn.cyclicEnumerations.Predecessor;
import fr.lip6.move.pnml.hlpn.cyclicEnumerations.Successor;

import fr.lip6.move.pnml.hlpn.cyclicEnumerations.impl.CyclicEnumerationsFactoryImpl;

import fr.lip6.move.pnml.hlpn.dots.Dot;
import fr.lip6.move.pnml.hlpn.dots.DotConstant;

import fr.lip6.move.pnml.hlpn.dots.impl.DotsFactoryImpl;

import fr.lip6.move.pnml.hlpn.finiteEnumerations.FEConstant;
import fr.lip6.move.pnml.hlpn.finiteEnumerations.FiniteEnumeration;

import fr.lip6.move.pnml.hlpn.finiteEnumerations.impl.FiniteEnumerationsFactoryImpl;

import fr.lip6.move.pnml.hlpn.finiteIntRanges.FiniteIntRange;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.FiniteIntRangeConstant;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.GreaterThan;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.GreaterThanOrEqual;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.LessThan;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.LessThanOrEqual;

import fr.lip6.move.pnml.hlpn.finiteIntRanges.impl.FiniteIntRangesFactoryImpl;

import fr.lip6.move.pnml.hlpn.hlcorestructure.Annotation;
import fr.lip6.move.pnml.hlpn.hlcorestructure.AnnotationGraphics;
import fr.lip6.move.pnml.hlpn.hlcorestructure.AnyObject;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Arc;
import fr.lip6.move.pnml.hlpn.hlcorestructure.ArcGraphics;
import fr.lip6.move.pnml.hlpn.hlcorestructure.CSS2Color;
import fr.lip6.move.pnml.hlpn.hlcorestructure.CSS2FontFamily;
import fr.lip6.move.pnml.hlpn.hlcorestructure.CSS2FontSize;
import fr.lip6.move.pnml.hlpn.hlcorestructure.CSS2FontStyle;
import fr.lip6.move.pnml.hlpn.hlcorestructure.CSS2FontWeight;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Condition;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Declaration;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Dimension;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Fill;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Font;
import fr.lip6.move.pnml.hlpn.hlcorestructure.FontAlign;
import fr.lip6.move.pnml.hlpn.hlcorestructure.FontDecoration;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Gradient;
import fr.lip6.move.pnml.hlpn.hlcorestructure.HLAnnotation;
import fr.lip6.move.pnml.hlpn.hlcorestructure.HLMarking;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Label;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Line;
import fr.lip6.move.pnml.hlpn.hlcorestructure.LineShape;
import fr.lip6.move.pnml.hlpn.hlcorestructure.LineStyle;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Name;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Node;
import fr.lip6.move.pnml.hlpn.hlcorestructure.NodeGraphics;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Offset;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PNType;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Page;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNetDoc;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Place;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PlaceNode;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PnObject;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Position;
import fr.lip6.move.pnml.hlpn.hlcorestructure.RefPlace;
import fr.lip6.move.pnml.hlpn.hlcorestructure.RefTransition;
import fr.lip6.move.pnml.hlpn.hlcorestructure.ToolInfo;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Transition;
import fr.lip6.move.pnml.hlpn.hlcorestructure.TransitionNode;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Type;

import fr.lip6.move.pnml.hlpn.hlcorestructure.impl.HlcorestructureFactoryImpl;

import fr.lip6.move.pnml.hlpn.integers.impl.IntegersFactoryImpl;

import fr.lip6.move.pnml.hlpn.lists.EmptyList;
import fr.lip6.move.pnml.hlpn.lists.HLPNList;
import fr.lip6.move.pnml.hlpn.lists.MakeList;

import fr.lip6.move.pnml.hlpn.lists.impl.ListsFactoryImpl;

import fr.lip6.move.pnml.hlpn.multisets.All;
import fr.lip6.move.pnml.hlpn.multisets.Empty;

import fr.lip6.move.pnml.hlpn.multisets.impl.MultisetsFactoryImpl;

import fr.lip6.move.pnml.hlpn.partitions.Partition;
import fr.lip6.move.pnml.hlpn.partitions.PartitionElement;

import fr.lip6.move.pnml.hlpn.partitions.impl.PartitionsFactoryImpl;

import fr.lip6.move.pnml.hlpn.strings.impl.StringsFactoryImpl;

import fr.lip6.move.pnml.hlpn.terms.Declarations;
import fr.lip6.move.pnml.hlpn.terms.MultisetSort;
import fr.lip6.move.pnml.hlpn.terms.NamedOperator;
import fr.lip6.move.pnml.hlpn.terms.NamedSort;
import fr.lip6.move.pnml.hlpn.terms.Operator;
import fr.lip6.move.pnml.hlpn.terms.ProductSort;
import fr.lip6.move.pnml.hlpn.terms.Sort;
import fr.lip6.move.pnml.hlpn.terms.Term;
import fr.lip6.move.pnml.hlpn.terms.VariableDecl;

import fr.lip6.move.pnml.hlpn.terms.impl.TermsFactoryImpl;

import java.math.BigDecimal;

import java.net.URI;

import java.util.List;

import  fr.lip6.move.pnml.framework.hlapi.*;
import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.hlapi.*;
import fr.lip6.move.pnml.hlpn.booleans.hlapi.*;
import fr.lip6.move.pnml.hlpn.cyclicEnumerations.hlapi.*;
import fr.lip6.move.pnml.hlpn.dots.hlapi.*;
import fr.lip6.move.pnml.hlpn.finiteEnumerations.hlapi.*;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.hlapi.*;
import fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.*;
import fr.lip6.move.pnml.hlpn.integers.hlapi.*;
import fr.lip6.move.pnml.hlpn.lists.hlapi.*;
import fr.lip6.move.pnml.hlpn.multisets.hlapi.*;
import fr.lip6.move.pnml.hlpn.partitions.hlapi.*;
import fr.lip6.move.pnml.hlpn.strings.hlapi.*;
import fr.lip6.move.pnml.hlpn.terms.hlapi.*;

import java.util.ArrayList;
import java.util.List;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import org.apache.axiom.om.*;
import fr.lip6.move.pnml.framework.utils.IdRefLinker;
import org.eclipse.emf.common.util.DiagnosticChain;
import fr.lip6.move.pnml.hlpn.hlcorestructure.*;
import fr.lip6.move.pnml.hlpn.hlcorestructure.impl.*;
import fr.lip6.move.pnml.framework.utils.exception.InnerBuildException;
import fr.lip6.move.pnml.framework.utils.exception.InvalidIDException;
import fr.lip6.move.pnml.framework.utils.exception.VoidRepositoryException;
import fr.lip6.move.pnml.framework.utils.exception.OtherException;
import fr.lip6.move.pnml.framework.utils.IdRepository;
import fr.lip6.move.pnml.framework.utils.ModelRepository;


public class DeclarationHLAPI implements HLAPIClass,LabelHLAPI,AnnotationHLAPI{

	/**
	 * The contained LLAPI element.
	 */
	private Declaration item;

	/**
	 * this constructor allows you to set all 'settable' values
	 * excepted container.
	 */
	
	public DeclarationHLAPI(
		 AnnotationGraphicsHLAPI annotationgraphics
	
		, java.lang.String text
	
		, DeclarationsHLAPI structure
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createDeclaration();}
	
 		
 		if(annotationgraphics!=null)
			item.setAnnotationgraphics((AnnotationGraphics)annotationgraphics.getContainedItem());
		
	
 		
			if(text!=null){
			
				item.setText(text);
			}
		
	
 		
 		if(structure!=null)
			item.setStructure((Declarations)structure.getContainedItem());
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	
	public DeclarationHLAPI(
		 AnnotationGraphicsHLAPI annotationgraphics
	
		, java.lang.String text
	
		, DeclarationsHLAPI structure
	
		, PetriNetHLAPI containerDeclarationPetriNet
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createDeclaration();}
	
 		
 		if(annotationgraphics!=null)
			item.setAnnotationgraphics((AnnotationGraphics)annotationgraphics.getContainedItem());
		
	
 		
			if(text!=null){
			
				item.setText(text);
			}
		
	
 		
 		if(structure!=null)
			item.setStructure((Declarations)structure.getContainedItem());
		
	
 		
 		if(containerDeclarationPetriNet!=null)
			item.setContainerDeclarationPetriNet((PetriNet)containerDeclarationPetriNet.getContainedItem());
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	
	public DeclarationHLAPI(
		 AnnotationGraphicsHLAPI annotationgraphics
	
		, java.lang.String text
	
		, DeclarationsHLAPI structure
	
		, PageHLAPI containerDeclarationPage
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createDeclaration();}
	
 		
 		if(annotationgraphics!=null)
			item.setAnnotationgraphics((AnnotationGraphics)annotationgraphics.getContainedItem());
		
	
 		
			if(text!=null){
			
				item.setText(text);
			}
		
	
 		
 		if(structure!=null)
			item.setStructure((Declarations)structure.getContainedItem());
		
	
 		
 		if(containerDeclarationPage!=null)
			item.setContainerDeclarationPage((Page)containerDeclarationPage.getContainedItem());
		
	
	}



	
	/**
    * This constructor give access to required stuff only (and container)
    */
	public DeclarationHLAPI(
		 PetriNetHLAPI containerDeclarationPetriNet
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createDeclaration();}
	
 		
 		if(containerDeclarationPetriNet!=null)
			item.setContainerDeclarationPetriNet((PetriNet)containerDeclarationPetriNet.getContainedItem());
		
	
	}
	
	
	/**
    * This constructor give access to required stuff only (and container)
    */
	public DeclarationHLAPI(
		 PageHLAPI containerDeclarationPage
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createDeclaration();}
	
 		
 		if(containerDeclarationPage!=null)
			item.setContainerDeclarationPage((Page)containerDeclarationPage.getContainedItem());
		
	
	}
	

	/**
	 * This constructor encapsulate a low level API object in HLAPI.
	 */
	public DeclarationHLAPI(Declaration lowLevelAPI){
		item = lowLevelAPI;
	}

	// access to low level API
	/**
	 * Return encapsulated object
	 */
	public Declaration getContainedItem(){
		return item;
	}

	//getters giving LLAPI object
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public List<ToolInfo> getToolspecifics(){
		return item.getToolspecifics();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public AnnotationGraphics getAnnotationgraphics(){
		return item.getAnnotationgraphics();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public String getText(){
		return item.getText();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public Declarations getStructure(){
		return item.getStructure();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public PetriNet getContainerDeclarationPetriNet(){
		return item.getContainerDeclarationPetriNet();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public Page getContainerDeclarationPage(){
		return item.getContainerDeclarationPage();
	}
	

	//getters giving HLAPI object
	
	
	
		/**
		 * This accessor automatically encapsulate all elements of the selected sublist.
		 * WARNING : this can creates a lot of new object in memory.
		 */
		
		public java.util.List<ToolInfoHLAPI> getToolspecificsHLAPI(){
			java.util.List<ToolInfoHLAPI> retour = new ArrayList<ToolInfoHLAPI>();
			for (ToolInfo elemnt : getToolspecifics()) {
				retour.add(new ToolInfoHLAPI(elemnt));
			}
			return retour;
		}
	
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public AnnotationGraphicsHLAPI getAnnotationgraphicsHLAPI(){
			if(item.getAnnotationgraphics() == null) return null;
			return new AnnotationGraphicsHLAPI(item.getAnnotationgraphics());
		}
		
	
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public DeclarationsHLAPI getStructureHLAPI(){
			if(item.getStructure() == null) return null;
			return new DeclarationsHLAPI(item.getStructure());
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public PetriNetHLAPI getContainerDeclarationPetriNetHLAPI(){
			if(item.getContainerDeclarationPetriNet() == null) return null;
			return new PetriNetHLAPI(item.getContainerDeclarationPetriNet());
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public PageHLAPI getContainerDeclarationPageHLAPI(){
			if(item.getContainerDeclarationPage() == null) return null;
			return new PageHLAPI(item.getContainerDeclarationPage());
		}
		
	
	

	//Special getter for list of generics object, return only one object type.
	
	
	
	
	
	

	//setters (including container setter if aviable)
	
	
	/**
	 * set Annotationgraphics
	 */
	public void setAnnotationgraphicsHLAPI(
	
	AnnotationGraphicsHLAPI elem){
	
	
 		if(elem!=null)
			item.setAnnotationgraphics((AnnotationGraphics)elem.getContainedItem());
	
	}
	
	/**
	 * set Text
	 */
	public void setTextHLAPI(
	
	java.lang.String elem){
	
	
		if(elem!=null){
		
			item.setText(elem);
		}
	
	}
	
	/**
	 * set Structure
	 */
	public void setStructureHLAPI(
	
	DeclarationsHLAPI elem){
	
	
 		if(elem!=null)
			item.setStructure((Declarations)elem.getContainedItem());
	
	}
	
	/**
	 * set ContainerDeclarationPetriNet
	 */
	public void setContainerDeclarationPetriNetHLAPI(
	
	PetriNetHLAPI elem){
	
	
 		if(elem!=null)
			item.setContainerDeclarationPetriNet((PetriNet)elem.getContainedItem());
	
	}
	
	/**
	 * set ContainerDeclarationPage
	 */
	public void setContainerDeclarationPageHLAPI(
	
	PageHLAPI elem){
	
	
 		if(elem!=null)
			item.setContainerDeclarationPage((Page)elem.getContainedItem());
	
	}
	

	//setters/remover for lists.
	
	
	public void addToolspecificsHLAPI(ToolInfoHLAPI unit){
	
		item.getToolspecifics().add((ToolInfo)unit.getContainedItem());
	}

	public void removeToolspecificsHLAPI(ToolInfoHLAPI unit){
		item.getToolspecifics().remove((ToolInfo)unit.getContainedItem());
	}
	

	//equals method
	public boolean equals(DeclarationHLAPI item){
		return item.getContainedItem().equals(getContainedItem());
	}

	//PNML
	
	/**
	 * Returns the PNML xml tree for this object.
	 */
	public String toPNML(){
		return item.toPNML();
	}
	
	/**
	 * Writes the PNML XML tree of this object into file channel.
	 */
	public void toPNML(FileChannel fc){
		 item.toPNML(fc);
	}

	/**
	 * creates an object from the xml nodes.(symetric work of toPNML)
	 */
	public void fromPNML(OMElement subRoot,IdRefLinker idr) throws InnerBuildException, InvalidIDException, VoidRepositoryException{
		item.fromPNML(subRoot,idr);
	}
	

	public boolean validateOCL(DiagnosticChain diagnostics){
		return item.validateOCL(diagnostics);
	}

}