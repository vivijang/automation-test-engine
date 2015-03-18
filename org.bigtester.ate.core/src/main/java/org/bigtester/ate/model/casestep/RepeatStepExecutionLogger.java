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

import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.tree.DefaultTreeModel;

import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * This class RepeatStepExecutionLogger defines ....
 * 
 * @author Peidong Hu
 *
 */
public class RepeatStepExecutionLogger {
	final private Map<String, DefaultTreeModel> repeatStepTrees = new ConcurrentHashMap<String, DefaultTreeModel>();

	/**
	 * @return the repeatStepTrees
	 */
	public Map<String, DefaultTreeModel> getRepeatStepTrees() {
		return repeatStepTrees;
	}

	public void addRepeatStepName(String repeatStepName) {
		if (repeatStepTrees.containsKey(repeatStepName))
			return;
		RepeatStepExecutionLoggerNode rootNode = new RepeatStepExecutionLoggerNode(
				repeatStepName);
		DefaultTreeModel repeatStepTree = new DefaultTreeModel(rootNode);
		repeatStepTrees.put(repeatStepName, repeatStepTree);
	}

	private @Nullable RepeatStepExecutionLoggerNode searchStepNode(
			RepeatStepExecutionLoggerNode rootNode, String stepName) {

		RepeatStepExecutionLoggerNode theNode = null;
		for (Enumeration enumer = rootNode.depthFirstEnumeration(); enumer
				.hasMoreElements() && theNode == null;) {
			RepeatStepExecutionLoggerNode node = (RepeatStepExecutionLoggerNode) enumer
					.nextElement();
			if (((String) node.getUserObject()).equals(stepName)) {
				theNode = node;
			}
		}
		return theNode;
	}

	public void addChildRepeatStepName(String childStepName,
			String parentStepName) {
		DefaultTreeModel childRootedStepTree = repeatStepTrees
				.get(childStepName);
		if (null == childRootedStepTree) {
			// for (Map.Entry<String, DefaultTreeModel> entry : repeatStepTrees
			// .entrySet()) {
			// String rootStepName = entry.getKey();
			// RepeatStepExecutionLoggerNode stepTreeRoot =
			// (RepeatStepExecutionLoggerNode) entry
			// .getValue().getRoot();
			// if (rootStepName != null && stepTreeRoot != null) {
			// RepeatStepExecutionLoggerNode childNode = searchStepNode(
			// stepTreeRoot, rootStepName);
			// if (null != childNode)
			// break;
			// }
			// }
		} else {
			DefaultTreeModel parentStepTree = repeatStepTrees
					.get(parentStepName);
			RepeatStepExecutionLoggerNode newRootNode;
			if (null == parentStepTree) {
				newRootNode = new RepeatStepExecutionLoggerNode(
						parentStepName);
			} else {
				newRootNode = (RepeatStepExecutionLoggerNode) parentStepTree
						.getRoot();
			}
			newRootNode.add((RepeatStepExecutionLoggerNode) childRootedStepTree
					.getRoot());
			repeatStepTrees.put(parentStepName, new DefaultTreeModel(
					newRootNode));
			repeatStepTrees.remove(childStepName);

		}
		DefaultTreeModel parentStepNode = repeatStepTrees.get(childStepName);
		RepeatStepExecutionLoggerNode rootNode = new RepeatStepExecutionLoggerNode(
				childStepName);

	}
}
