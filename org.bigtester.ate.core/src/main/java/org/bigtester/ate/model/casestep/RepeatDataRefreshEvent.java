/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2015, Montreal PROT, or individual contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Montreal PROT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.bigtester.ate.model.casestep;

import java.util.Arrays;

import javax.swing.tree.TreeNode;

import org.bigtester.ate.GlobalUtils;
import org.springframework.context.ApplicationEvent;

// TODO: Auto-generated Javadoc
/**
 * This class RepeatDataRefreshEvent defines ....
 * 
 * @author Peidong Hu
 *
 */
public class RepeatDataRefreshEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6313585724147559106L;

	/** The iteration. */
	final private int iteration;

	/** The repeat step path nodes. */
	final private TreeNode[] repeatStepInvokePathNodes;

	/**
	 * Instantiates a new repeat data refresh event.
	 *
	 * @param source
	 *            the source
	 * @param repeatStepInvokePathNodes
	 *            the repeat step invoke path nodes
	 * @param iteration
	 *            the iteration
	 */
	public RepeatDataRefreshEvent(RepeatStep source,
			TreeNode[] repeatStepInvokePathNodes, int iteration) {
		super(source);
		TreeNode[] temp = Arrays.copyOf(repeatStepInvokePathNodes,
				repeatStepInvokePathNodes.length);
		if (null == temp)
			throw GlobalUtils
					.createInternalError("error in copying array, repeatStepInvokePathNodes");
		else
			this.repeatStepInvokePathNodes = temp;
		this.iteration = iteration;
	}

	/**
	 * @param repeatStep
	 * @param i
	 */
	public RepeatDataRefreshEvent(Object source) {
		super(source);
		this.iteration = 0;
		this.repeatStepInvokePathNodes = new TreeNode[0];
	}

	/**
	 * Gets the repeat step name.
	 *
	 * @return the repeat step name
	 */
	public String getRepeatStepName() {
		RepeatStepExecutionLoggerNode retVal = (RepeatStepExecutionLoggerNode) repeatStepInvokePathNodes[repeatStepInvokePathNodes.length - 1];
		String retV = (String) retVal.getUserObject();
		if (null == retV)
			throw GlobalUtils
					.createInternalError("repeat step name conversion error");
		else
			return retV;
	}
	
	/**
	 * Gets the repeat step loop path.
	 *
	 * @return the repeat step loop path, if repeat step loop path is null, return "" empty string.
	 */
	
	public String getRepeatStepExternalLoopPath() {
		StringBuilder builder = new StringBuilder("");
		for (int index=0; index<=repeatStepInvokePathNodes.length - 2; index++) {
			RepeatStepExecutionLoggerNode tempNode = (RepeatStepExecutionLoggerNode) repeatStepInvokePathNodes[index];
			builder.append(  (String) tempNode.getUserObject());
			if (index < repeatStepInvokePathNodes.length - 2)
				builder.append("->");
		}
		String retVal = builder.toString();
		if (null == retVal) throw GlobalUtils.createInternalError("get repeat step loop path.");
		return retVal;
	}

	/**
	 * @return the iteration
	 */
	public int getIteration() {
		return iteration;
	}

	/**
	 * @return the repeatStepInvokePathNodes
	 */
	public TreeNode[] getRepeatStepInvokePathNodes() {
		TreeNode[] temp = Arrays.copyOf(repeatStepInvokePathNodes,
				repeatStepInvokePathNodes.length);
		if (null == temp)
			throw GlobalUtils
					.createInternalError("error in copying array, repeatStepInvokePathNodes");
		else
			return temp;
	}

}
