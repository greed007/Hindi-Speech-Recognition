
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame implements Runnable {

    HindiStuff ob;

    public GUI() throws IOException {
        initComponents();
        ob = new HindiStuff();
        ob.initdict();
        ob.initConversion();
    }

    String fixedtext = "Please Enter the new sentence which you want to train ?";
    boolean train;
    int number;
    Thread t;
    TargetDataLine line;
    AudioInputStream ais;

    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
        return format;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hindiText = new java.awt.TextArea();
        record = new java.awt.Button();
        stopRecording = new java.awt.Button();
        start = new java.awt.Button();
        stop = new java.awt.Button();
        hindiSpeech = new java.awt.TextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        startTraining = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Hindi Speech Recognition System");

        jLabel2.setText("Train");

        jLabel3.setText("Test");

        hindiText.setText("Please Enter the new sentence which you want to train ?");

        record.setActionCommand("Record");
        record.setLabel("Record");
        record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordActionPerformed(evt);
            }
        });

        stopRecording.setActionCommand("StopRecording");
        stopRecording.setLabel("StopRecording");
        stopRecording.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopRecordingActionPerformed(evt);
            }
        });

        start.setActionCommand("Start");
        start.setLabel("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        stop.setActionCommand("Stop");
        stop.setLabel("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        hindiSpeech.setText("What you spoke?");

        jLabel4.setText("OnLiveAudio");

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        startTraining.setText("train");
        startTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTrainingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(147, 147, 147)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(hindiText, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(hindiSpeech, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(record, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(109, 109, 109)
                                    .addComponent(jButton1))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(stopRecording, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(startTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hindiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(record, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stopRecording, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startTraining))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addComponent(hindiSpeech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        hindiText.getAccessibleContext().setAccessibleName("");
        hindiText.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void run() {
        if (train) {
            try {
                AudioFormat format = getAudioFormat();
                DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
                // checks if system supports the data line
                if (!AudioSystem.isLineSupported(info)) {
                    System.out.println("Line not supported");
                    System.exit(0);
                }
                line = (TargetDataLine) AudioSystem.getLine(info);
                line.open(format);
                line.start();
                System.out.println("Start capturing...");
                ais = new AudioInputStream(line);

                System.out.println("Start recording...");
                AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File("Hindi/audio_files/FilestoTrain/file" + number + ".wav"));

                System.out.println("Ended.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                AudioFormat format = getAudioFormat();
                DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
                // checks if system supports the data line
                if (!AudioSystem.isLineSupported(info)) {
                    System.out.println("Line not supported");
                    System.exit(0);
                }
                line = (TargetDataLine) AudioSystem.getLine(info);
                line.open(format);
                line.start();
                System.out.println("Start capturing...");
                ais = new AudioInputStream(line);

                System.out.println("Start recording...");
                AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File("Hindi/audio_files/testHere/test" + number + ".wav"));

                System.out.println("Ended.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordActionPerformed
        String line = hindiText.getText();
        if (line.equals(fixedtext)) {
            JOptionPane.showMessageDialog(this, "Enter text to be trained.");
            return;
        }
        number = (new File("Hindi/audio_files/FilestoTrain")).list().length;
        number++;
        try {
            ob.manageTextForTraining(line, number);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        train = true;
        t = new Thread(this);
        hindiText.setText("SpeakNow");
        t.start();
    }//GEN-LAST:event_recordActionPerformed

    private void stopRecordingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopRecordingActionPerformed
        line.stop();
        line.close();
        try {
            ais.close();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        hindiText.setText(fixedtext);
        
        ProcessBuilder pb = new ProcessBuilder("/home/sanjay/NetBeansProjects/SoundRecorder/createLangModel.sh");
        Process p = null;
        try {
            p = pb.start();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            p.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ended creating language model.");
        

        long s,e;
        
        s = System.currentTimeMillis();
        ProcessBuilder pbb = new ProcessBuilder("/home/sanjay/NetBeansProjects/SoundRecorder/createAcoustic.sh");
        Process pp = null;
        try {
            pp = pbb.start();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pp.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        e = System.currentTimeMillis();
        
        System.out.println("Time elapsed : " + (e-s) + " millisec.");
        System.out.println("Ended training.");
                
    }//GEN-LAST:event_stopRecordingActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        number = (new File("Hindi/audio_files/testHere")).list().length;
        number++;
        train = false;
        t = new Thread(this);
        t.start();

        String hindi = null;
        try {
            hindi = ob.manageForRecording(number);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(hindi.equals("")) hindiSpeech.setText("Didn't Recognize.");
        else hindiSpeech.setText(hindi);
    }//GEN-LAST:event_startActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        line.stop();
        line.close();
        try {
            ais.close();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stopActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        JFileChooser fc = new JFileChooser();
        
        fc.setCurrentDirectory(new File("/home/sanjay/NetBeansProjects/SoundRecorder/Hindi/audio_files/"));
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            
            try {
                String hindi = ob.testRecording(file);
                if(hindi.equals("")) hindiSpeech.setText("Didn't Recognize.");
                hindiSpeech.setText(hindi);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Open command cancelled by user.");
        }
    }//GEN-LAST:event_browseActionPerformed

    private void startTrainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTrainingActionPerformed
        String line = hindiText.getText();
        if (line.equals(fixedtext)) {
            JOptionPane.showMessageDialog(this, "Enter text to be trained.");
            return;
        }
        number = (new File("Hindi/audio_files/FilestoTrain")).list().length;
        try {
            ob.manageTextForTraining(line, number);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        hindiText.setText(fixedtext);
        ProcessBuilder pb = new ProcessBuilder("/home/sanjay/NetBeansProjects/SoundRecorder/createLangModel.sh");
        Process p = null;
        try {
            p = pb.start();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            p.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ended creating language model.");
        

        ProcessBuilder pbb = new ProcessBuilder("/home/sanjay/NetBeansProjects/SoundRecorder/createAcoustic.sh");
        Process pp = null;
        try {
            pp = pbb.start();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pp.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ended training.");
        
    }//GEN-LAST:event_startTrainingActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea hindiSpeech;
    private java.awt.TextArea hindiText;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private java.awt.Button record;
    private java.awt.Button start;
    private javax.swing.JButton startTraining;
    private java.awt.Button stop;
    private java.awt.Button stopRecording;
    // End of variables declaration//GEN-END:variables

}
