/*
 * Copyright 2009 Georgios "cyberpython" Migdos cyberpython@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License
 *       at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package glossaeditor.ui.components.misc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cyberpython
 */
public class JColorButton extends JButton {

    private final int MARGIN_LEFT = 5;
    private int MARGIN_TOP = 5;
    private final int WIDTH_DIFF = 10;
    private int HEIGHT_DIFF = 10;
    private Color color;
    private JLabel listeningLabel;
    private JPanel listeningPanel;
    private boolean colorModified;

    public JColorButton() {
        super();
        this.color = Color.WHITE;
        this.colorModified = false;
        this.setText("");
        this.setPreferredSize(new Dimension(40, 26));
        this.listeningLabel = null;
        this.listeningPanel = null;
        this.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                colorModified = false;
                if (isEnabled() && (e.getButton() == MouseEvent.BUTTON1)) {
                    Color selection = JColorChooser.showDialog(JColorButton.this, "Επιλογή χρώματος", color);
                    if (selection != null) {
                        color = selection;
                        colorModified = true;
                        repaint();
                        if (listeningLabel != null) {
                            listeningLabel.setForeground(color);
                            listeningLabel.repaint();
                        }
                        if (listeningPanel != null) {
                            listeningPanel.setBackground(color);
                            listeningPanel.repaint();
                        }
                    }

                }
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
        if (this.color == null) {
            this.color = Color.WHITE;
            this.repaint();
        }
        if (this.listeningLabel != null) {
            this.listeningLabel.setForeground(this.color);
            this.listeningLabel.repaint();
        }

        if (this.listeningPanel != null) {
            this.listeningPanel.setBackground(this.color);
            this.listeningPanel.repaint();
        }
    }

    public JLabel getListeningLabel() {
        return this.listeningLabel;
    }

    public void setListeningLabel(JLabel label) {
        this.listeningLabel = label;
    }

    public JPanel getListeningPanel() {
        return this.listeningPanel;
    }

    public void setListeningPanel(JPanel panel) {
        this.listeningPanel = panel;
    }

    public boolean getColorModified() {
        return this.colorModified;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        int w = this.getWidth() - WIDTH_DIFF;
        int h = this.getHeight() - HEIGHT_DIFF;
        g.setColor(this.color);
        g.fillRect(MARGIN_LEFT, MARGIN_TOP, w, h);
        g.setColor(Color.BLACK);
        g.drawRect(MARGIN_LEFT, MARGIN_TOP, w, h);


    }
}
