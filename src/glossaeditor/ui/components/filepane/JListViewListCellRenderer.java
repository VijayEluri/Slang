/*
 * JListViewListCellRenderer.java
 *
 * Created on 11 Δεκέμβριος 2008, 2:18 μμ
 */
package glossaeditor.ui.components.filepane;

import java.awt.Component;
import java.io.File;
import java.util.Hashtable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author  cyberpython
 */
public class JListViewListCellRenderer extends javax.swing.JPanel implements ListCellRenderer {

    /** Creates new form JListViewListCellRenderer */
    private final static String FS_LABEL = "Σύστημα αρχείων";

    private JLabel folderIconLabel;
    private JLabel fileIconLabel;
    private static Hashtable<String, ImageIcon> icons;

    public JListViewListCellRenderer() {
        this.folderIconLabel = null;
        this.fileIconLabel = null;

        if(JListViewListCellRenderer.icons == null){
            //TODO: FIXME
            JListViewListCellRenderer.icons = new Hashtable<String, ImageIcon>();
        }

        initComponents();

    }

    public void setFolderIconLabel(JLabel label) {
       this.folderIconLabel = label;
    }

    public void setFileIconLabel(JLabel label) {
       this.fileIconLabel = label;
    }

    public void setIconForExtension(String extension, ImageIcon icon) {
        JListViewListCellRenderer.icons.put(extension.toLowerCase(), icon);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof File) {
            initialize((File) value);
        }

        if (cellHasFocus) {
            this.setOpaque(true);
            this.setBackground(list.getSelectionBackground());
            this.setForeground(list.getSelectionForeground());
            jLabel1.setBackground(list.getSelectionBackground());
            jLabel1.setForeground(list.getSelectionForeground());

        } else {
            this.setOpaque(true);
            this.setBackground(list.getBackground());
            this.setForeground(list.getForeground());
            jLabel1.setBackground(list.getBackground());
            jLabel1.setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());

        return this;
    }

    public void initialize(File item) {


        if (item.isDirectory()) {


            jLabel1.setIcon(folderIconLabel.getIcon());

        } else if (item.isFile()) {
            String ext = getFileExtension(item);
            Icon icon = JListViewListCellRenderer.icons.get(ext);
            if(icon == null){
                icon = fileIconLabel.getIcon();
            }
            jLabel1.setIcon(icon);

        }

        if(!item.getAbsolutePath().equals("/")){
            String name = item.getName();
            if(name.trim().equals("")){
                name = item.getAbsolutePath();
            }
            jLabel1.setText(name);
        }else{
            jLabel1.setText(JListViewListCellRenderer.FS_LABEL);
        }
        
    }

    public static String getFileExtension(File f) {
        String fname = f.getName();
        int dotIndex = fname.lastIndexOf('.');
        if (  (0 < dotIndex) &&  (dotIndex <= fname.length() - 2) ) {
            return fname.substring(dotIndex + 1).toLowerCase();
        }
        return "";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(java.awt.SystemColor.text);

        jLabel1.setText("Filename");
        jLabel1.setMinimumSize(new java.awt.Dimension(47, 26));
        jLabel1.setPreferredSize(new java.awt.Dimension(47, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
