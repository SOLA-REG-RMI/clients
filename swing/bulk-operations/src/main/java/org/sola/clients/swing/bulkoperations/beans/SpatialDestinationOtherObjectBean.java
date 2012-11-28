/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.clients.swing.bulkoperations.beans;

import java.util.ArrayList;
import java.util.List;
import org.sola.clients.swing.bulkoperations.spatialobjects.SpatialDestinationOtherObjectPanel;

/**
 *
 * @author Elton Manoku
 */
public class SpatialDestinationOtherObjectBean extends SpatialDestinationBean {

    private static String PROPERTY_TYPE = "type";
    private static String PROPERTY_LABEL_ATTRIBUTE = "labelAttribute";
    
    private String type;
    private SpatialAttributeBean labelAttribute;
    
    
    private String code = "other_object";
    private String displayValue = "Other object";

    public SpatialDestinationOtherObjectBean() {
        setCode(code);
        setDisplayValue(displayValue);
    }

    @Override
    public String getPanelName() {
        return SpatialDestinationOtherObjectPanel.PANEL_NAME;
    }

    public SpatialAttributeBean getLabelAttribute() {
        return labelAttribute;
    }

    public void setLabelAttribute(SpatialAttributeBean value) {
        SpatialAttributeBean old = this.labelAttribute;
        this.labelAttribute = value;
        propertySupport.firePropertyChange(PROPERTY_LABEL_ATTRIBUTE, old, value);
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        String old = this.type;
        this.type = value;
        propertySupport.firePropertyChange(PROPERTY_TYPE, old, value);
    }
    

    @Override
    public List<SpatialUnitTemporaryBean> getBeans(SpatialSourceBean fromSource) {
        List<SpatialUnitTemporaryBean> beans = new ArrayList<SpatialUnitTemporaryBean>();
        List<SpatialAttributeBean> onlyAttributes = new ArrayList<SpatialAttributeBean>();
        onlyAttributes.add(labelAttribute);

        for (SpatialSourceObjectBean sourceObject : fromSource.getFeatures(onlyAttributes)) {
            SpatialUnitTemporaryBean bean = new  SpatialUnitTemporaryBean();
            bean.setTypeCode(code);
            bean.setLabel(
                    sourceObject.getFieldsWithValues().get(labelAttribute.getName()).toString());
            bean.setGeom(sourceObject.getTheGeom());            
            beans.add(bean);
        }
        return beans;
    }
}
