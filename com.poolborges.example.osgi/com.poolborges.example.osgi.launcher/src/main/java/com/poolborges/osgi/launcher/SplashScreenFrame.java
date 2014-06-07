/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.osgi.launcher;


import java.awt.Color;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author PauloBorges
 */
public class SplashScreenFrame extends JFrame
{
  private static final long serialVersionUID = 1720317968968383306L;

  public SplashScreenFrame(URL paramURL, Rectangle paramRectangle)
  {
    ImageIcon localImageIcon = new ImageIcon(paramURL);
    JProgressBar localJProgressBar = new JProgressBar();
    localJProgressBar.setIndeterminate(true);
    localJProgressBar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    localJProgressBar.setBackground(Color.WHITE);
    localJProgressBar.setForeground(new Color(26316));
    JLabel localJLabel = new JLabel(localImageIcon);
    localJLabel.setBounds(new Rectangle(0, 0, paramRectangle.width, paramRectangle.height));

    localJProgressBar.setBounds(new Rectangle(75, paramRectangle.height - 18, paramRectangle.width - 75 - 7, 10));

    JPanel localJPanel = new JPanel();
    localJPanel.setLayout(null);
    localJPanel.add(localJProgressBar);
    localJPanel.add(localJLabel);
    setContentPane(localJPanel);
    setUndecorated(true);
    setBounds(paramRectangle);
  }
}
