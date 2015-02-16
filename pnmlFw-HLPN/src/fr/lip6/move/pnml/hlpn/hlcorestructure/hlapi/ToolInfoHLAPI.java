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

import fr.lip6.move.pnml.hlpn.hlcorestructure.AnnotationGraphics;
import fr.lip6.move.pnml.hlpn.hlcorestructure.AnyObject;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Condition;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Declaration;
import fr.lip6.move.pnml.hlpn.hlcorestructure.HLAnnotation;
import fr.lip6.move.pnml.hlpn.hlcorestructure.HLMarking;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Label;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Name;
import fr.lip6.move.pnml.hlpn.hlcorestructure.NodeGraphics;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PNType;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Page;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNetDoc;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PnObject;
import fr.lip6.move.pnml.hlpn.hlcorestructure.ToolInfo;
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


public class ToolInfoHLAPI implements HLAPIClass{

	/**
	 * The contained LLAPI element.
	 */
	private ToolInfo item;

	/**
	 * this constructor allows you to set all 'settable' values
	 * excepted container.
	 */
	
	public ToolInfoHLAPI(
		 java.lang.String tool
	
		, java.lang.String version
	
		, java.lang.StringBuffer formattedXMLBuffer
	
		, java.net.URI toolInfoGrammarURI
	
		, AnyObjectHLAPI toolInfoModel
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createToolInfo();}
	
 		
			if(tool!=null){
			
				item.setTool(tool);
			}
		
	
 		
			if(version!=null){
			
				item.setVersion(version);
			}
		
	
 		
			if(formattedXMLBuffer!=null){
			
				item.setFormattedXMLBuffer(formattedXMLBuffer);
			}
		
	
 		
			if(toolInfoGrammarURI!=null){
			
				item.setToolInfoGrammarURI(toolInfoGrammarURI);
			}
		
	
 		
 		if(toolInfoModel!=null)
			item.setToolInfoModel((AnyObject)toolInfoModel.getContainedItem());
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	
	public ToolInfoHLAPI(
		 java.lang.String tool
	
		, java.lang.String version
	
		, java.lang.StringBuffer formattedXMLBuffer
	
		, java.net.URI toolInfoGrammarURI
	
		, AnyObjectHLAPI toolInfoModel
	
		, PetriNetHLAPI containerPetriNet
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createToolInfo();}
	
 		
			if(tool!=null){
			
				item.setTool(tool);
			}
		
	
 		
			if(version!=null){
			
				item.setVersion(version);
			}
		
	
 		
			if(formattedXMLBuffer!=null){
			
				item.setFormattedXMLBuffer(formattedXMLBuffer);
			}
		
	
 		
			if(toolInfoGrammarURI!=null){
			
				item.setToolInfoGrammarURI(toolInfoGrammarURI);
			}
		
	
 		
 		if(toolInfoModel!=null)
			item.setToolInfoModel((AnyObject)toolInfoModel.getContainedItem());
		
	
 		
 		if(containerPetriNet!=null)
			item.setContainerPetriNet((PetriNet)containerPetriNet.getContainedItem());
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	
	public ToolInfoHLAPI(
		 java.lang.String tool
	
		, java.lang.String version
	
		, java.lang.StringBuffer formattedXMLBuffer
	
		, java.net.URI toolInfoGrammarURI
	
		, AnyObjectHLAPI toolInfoModel
	
		, PnObjectHLAPI containerPnObject
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createToolInfo();}
	
 		
			if(tool!=null){
			
				item.setTool(tool);
			}
		
	
 		
			if(version!=null){
			
				item.setVersion(version);
			}
		
	
 		
			if(formattedXMLBuffer!=null){
			
				item.setFormattedXMLBuffer(formattedXMLBuffer);
			}
		
	
 		
			if(toolInfoGrammarURI!=null){
			
				item.setToolInfoGrammarURI(toolInfoGrammarURI);
			}
		
	
 		
 		if(toolInfoModel!=null)
			item.setToolInfoModel((AnyObject)toolInfoModel.getContainedItem());
		
	
 		
 		if(containerPnObject!=null)
			item.setContainerPnObject((PnObject)containerPnObject.getContainedItem());
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	
	public ToolInfoHLAPI(
		 java.lang.String tool
	
		, java.lang.String version
	
		, java.lang.StringBuffer formattedXMLBuffer
	
		, java.net.URI toolInfoGrammarURI
	
		, AnyObjectHLAPI toolInfoModel
	
		, LabelHLAPI containerLabel
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createToolInfo();}
	
 		
			if(tool!=null){
			
				item.setTool(tool);
			}
		
	
 		
			if(version!=null){
			
				item.setVersion(version);
			}
		
	
 		
			if(formattedXMLBuffer!=null){
			
				item.setFormattedXMLBuffer(formattedXMLBuffer);
			}
		
	
 		
			if(toolInfoGrammarURI!=null){
			
				item.setToolInfoGrammarURI(toolInfoGrammarURI);
			}
		
	
 		
 		if(toolInfoModel!=null)
			item.setToolInfoModel((AnyObject)toolInfoModel.getContainedItem());
		
	
 		
 		if(containerLabel!=null)
			item.setContainerLabel((Label)containerLabel.getContainedItem());
		
	
	}


	/**
    * This constructor give access to required stuff only (not container if any)
    */
	public ToolInfoHLAPI(
		 java.lang.String tool
	
		, java.lang.String version
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createToolInfo();}
	
 		
			if(tool!=null){
			
				item.setTool(tool);
			}
		
	
 		
			if(version!=null){
			
				item.setVersion(version);
			}
		
	
	}


	
	/**
    * This constructor give access to required stuff only (and container)
    */
	public ToolInfoHLAPI(
		 java.lang.String tool
	
		, java.lang.String version
	
		, PetriNetHLAPI containerPetriNet
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createToolInfo();}
	
 		
			if(tool!=null){
			
				item.setTool(tool);
			}
		
	
 		
			if(version!=null){
			
				item.setVersion(version);
			}
		
	
 		
 		if(containerPetriNet!=null)
			item.setContainerPetriNet((PetriNet)containerPetriNet.getContainedItem());
		
	
	}
	
	
	/**
    * This constructor give access to required stuff only (and container)
    */
	public ToolInfoHLAPI(
		 java.lang.String tool
	
		, java.lang.String version
	
		, PnObjectHLAPI containerPnObject
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createToolInfo();}
	
 		
			if(tool!=null){
			
				item.setTool(tool);
			}
		
	
 		
			if(version!=null){
			
				item.setVersion(version);
			}
		
	
 		
 		if(containerPnObject!=null)
			item.setContainerPnObject((PnObject)containerPnObject.getContainedItem());
		
	
	}
	
	
	/**
    * This constructor give access to required stuff only (and container)
    */
	public ToolInfoHLAPI(
		 java.lang.String tool
	
		, java.lang.String version
	
		, LabelHLAPI containerLabel
	){//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createToolInfo();}
	
 		
			if(tool!=null){
			
				item.setTool(tool);
			}
		
	
 		
			if(version!=null){
			
				item.setVersion(version);
			}
		
	
 		
 		if(containerLabel!=null)
			item.setContainerLabel((Label)containerLabel.getContainedItem());
		
	
	}
	

	/**
	 * This constructor encapsulate a low level API object in HLAPI.
	 */
	public ToolInfoHLAPI(ToolInfo lowLevelAPI){
		item = lowLevelAPI;
	}

	// access to low level API
	/**
	 * Return encapsulated object
	 */
	public ToolInfo getContainedItem(){
		return item;
	}

	//getters giving LLAPI object
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public String getTool(){
		return item.getTool();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public String getVersion(){
		return item.getVersion();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public StringBuffer getFormattedXMLBuffer(){
		return item.getFormattedXMLBuffer();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public URI getToolInfoGrammarURI(){
		return item.getToolInfoGrammarURI();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public PetriNet getContainerPetriNet(){
		return item.getContainerPetriNet();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public PnObject getContainerPnObject(){
		return item.getContainerPnObject();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public Label getContainerLabel(){
		return item.getContainerLabel();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public AnyObject getToolInfoModel(){
		return item.getToolInfoModel();
	}
	

	//getters giving HLAPI object
	
	
	
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public PetriNetHLAPI getContainerPetriNetHLAPI(){
			if(item.getContainerPetriNet() == null) return null;
			return new PetriNetHLAPI(item.getContainerPetriNet());
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		
		public PnObjectHLAPI getContainerPnObjectHLAPI(){
			if(item.getContainerPnObject() == null) return null;
			PnObject object = item.getContainerPnObject();
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.PageImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.PageHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.Page)object);
			}
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.ArcImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.ArcHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.Arc)object);
			}
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.PlaceImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.PlaceHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.Place)object);
			}
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.RefTransitionImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.RefTransitionHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.RefTransition)object);
			}
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.TransitionImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.TransitionHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.Transition)object);
			}
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.RefPlaceImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.RefPlaceHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.RefPlace)object);
			}
			
			return null;
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		
		public LabelHLAPI getContainerLabelHLAPI(){
			if(item.getContainerLabel() == null) return null;
			Label object = item.getContainerLabel();
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.NameImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.NameHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.Name)object);
			}
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.TypeImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.TypeHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.Type)object);
			}
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.HLMarkingImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.HLMarkingHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.HLMarking)object);
			}
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.ConditionImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.ConditionHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.Condition)object);
			}
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.HLAnnotationImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.HLAnnotationHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.HLAnnotation)object);
			}
			
			if(object.getClass().equals(fr.lip6.move.pnml.hlpn.hlcorestructure.impl.DeclarationImpl.class)){
				return new fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.DeclarationHLAPI((fr.lip6.move.pnml.hlpn.hlcorestructure.Declaration)object);
			}
			
			return null;
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		

	//Special getter for list of generics object, return only one object type.
	
	
	
	
	

	//setters (including container setter if aviable)
	
	
	/**
	 * set Tool
	 */
	public void setToolHLAPI(
	
	java.lang.String elem){
	
	
		if(elem!=null){
		
			item.setTool(elem);
		}
	
	}
	
	/**
	 * set Version
	 */
	public void setVersionHLAPI(
	
	java.lang.String elem){
	
	
		if(elem!=null){
		
			item.setVersion(elem);
		}
	
	}
	
	/**
	 * set FormattedXMLBuffer
	 */
	public void setFormattedXMLBufferHLAPI(
	
	java.lang.StringBuffer elem){
	
	
		if(elem!=null){
		
			item.setFormattedXMLBuffer(elem);
		}
	
	}
	
	/**
	 * set ToolInfoGrammarURI
	 */
	public void setToolInfoGrammarURIHLAPI(
	
	java.net.URI elem){
	
	
		if(elem!=null){
		
			item.setToolInfoGrammarURI(elem);
		}
	
	}
	
	/**
	 * set ToolInfoModel
	 */
	public void setToolInfoModelHLAPI(
	
	AnyObjectHLAPI elem){
	
	
 		if(elem!=null)
			item.setToolInfoModel((AnyObject)elem.getContainedItem());
	
	}
	
	/**
	 * set ContainerPetriNet
	 */
	public void setContainerPetriNetHLAPI(
	
	PetriNetHLAPI elem){
	
	
 		if(elem!=null)
			item.setContainerPetriNet((PetriNet)elem.getContainedItem());
	
	}
	
	/**
	 * set ContainerPnObject
	 */
	public void setContainerPnObjectHLAPI(
	
	PnObjectHLAPI elem){
	
	
 		if(elem!=null)
			item.setContainerPnObject((PnObject)elem.getContainedItem());
	
	}
	
	/**
	 * set ContainerLabel
	 */
	public void setContainerLabelHLAPI(
	
	LabelHLAPI elem){
	
	
 		if(elem!=null)
			item.setContainerLabel((Label)elem.getContainedItem());
	
	}
	

	//setters/remover for lists.
	

	//equals method
	public boolean equals(ToolInfoHLAPI item){
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