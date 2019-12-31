// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import frameFunzionali.WindowSalvataCc;
import listenerFrameCartellaClinica.FrameCartellaClinicaModel;
import java.awt.event.MouseEvent;
import frame.FrameCartellaClinica;
import oggetti.Paziente;
import oggetti.Reparto;
import javax.swing.JPanel;
import java.awt.event.MouseListener;

public class ClickSalvaCc implements MouseListener
{
    private JPanel accettazione;
    private JPanel infermieristica;
    private JPanel clinica;
    private JPanel terapia;
    private JPanel esame;
    private Reparto reparto;
    private String codFiscaele;
    private Paziente p1;
    private FrameCartellaClinica frame;
    
    public ClickSalvaCc(final JPanel panel_Accettazione, final JPanel panel_ValutazioneInizialeInfermieristica, final JPanel panel_ValutazioneClinicaIniziale, final JPanel panel_TerapiaDomiciliare, final JPanel panel_EsameObiettivo, final Reparto reparto, final String codFiscale, final Paziente p1, final FrameCartellaClinica frame) {
        this.accettazione = panel_Accettazione;
        this.infermieristica = panel_ValutazioneInizialeInfermieristica;
        this.clinica = panel_ValutazioneClinicaIniziale;
        this.terapia = panel_TerapiaDomiciliare;
        this.esame = panel_EsameObiettivo;
        this.reparto = reparto;
        this.codFiscaele = codFiscale;
        this.p1 = p1;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            FrameCartellaClinicaModel.serializzaPannelloAccettazione(this.accettazione, this.p1);
            FrameCartellaClinicaModel.serializzaPannelloValutazioneInizialeInfermieristica(this.infermieristica, this.p1);
            FrameCartellaClinicaModel.serializzaPannelloValutazioneInizialeClinica(this.clinica, this.p1);
            FrameCartellaClinicaModel.serializzaPannelloTerapiaDomiciliare(this.terapia, this.p1);
            FrameCartellaClinicaModel.serializzaPannelloEsameObiettivo(this.esame, this.p1);
            FrameCartellaClinicaModel.serializzaMatriceDiarioClinico(this.frame.getData(), this.p1);
            new WindowSalvataCc().setVisible(true);
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseExited(final MouseEvent arg0) {
    }
    
    @Override
    public void mousePressed(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent arg0) {
    }
}
