package com.dunneev.seenatural.Fragments.Piano;

import android.graphics.Color;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dunneev.seenatural.Enums.PianoNote;

import java.util.ArrayList;

public class PianoViewModel extends ViewModel {

    private final String LOG_TAG = this.getClass().getSimpleName();

    public static final int TOTAL_KEYS = 88;

    private MutableLiveData<Boolean> correctKeyPressed = new MutableLiveData<>();


    // todo: set piano note range based on options selected
    private PianoNote lowNote;
    private PianoNote highNote;

    private boolean isSingleOctaveMode;

    private MutableLiveData<PianoNote> keyPressed = new MutableLiveData<>();
    private MutableLiveData<PianoNote> keyReleased = new MutableLiveData<>();

    // TODO: Change colors to facilitate correct/incorrect when sight-reading
    public int whiteKeyUpColor = Color.WHITE;
    public int whiteKeyDownColor = Color.GRAY;
    public int whiteKeyDownCorrectColor = Color.GREEN;
    public int whiteKeyDownIncorrectColor = Color.RED;
    public int blackKeyUpColor = Color.BLACK;
    public int blackKeyDownColor = Color.LTGRAY;
    public int blackKeyDownCorrectColor = Color.GREEN;
    public int blackKeyDownIncorrectColor = Color.RED;

    public boolean getIsSingleOctaveMode() {
        return isSingleOctaveMode;
    }
    public void setIsSingleOctaveMode(boolean isSingleOctaveMode) {
        this.isSingleOctaveMode = isSingleOctaveMode;
        if (isSingleOctaveMode) {
            this.lowNote = PianoNote.C4;
            this.highNote = PianoNote.B4;
        }
    }

    public MutableLiveData<PianoNote> getMutableLiveDataKeyPressed() {
        return keyPressed;
    }
    public PianoNote getKeyPressed() {
        return keyPressed.getValue();
    }
    public void setKeyPressed(PianoNote note) {
        this.keyPressed.setValue(note);
    }

    public MutableLiveData<PianoNote> getMutableLiveDataKeyReleased() {
        return keyReleased;
    }
    public PianoNote getKeyReleased() {
        return keyReleased.getValue();
    }
    public void setKeyReleased(PianoNote note) {
        this.keyReleased.setValue(note);
    }


    // Do processing of data here in the ViewModel, UI management in the fragment.
    public void keyDown(PianoNote note) {
        setKeyPressed(note);
    }

    public void keyUp(PianoNote note) {
        setKeyReleased(note);
    }

    public void setLowNote(PianoNote lowNote) {
        this.lowNote = lowNote;
    }

    public void setHighNote(PianoNote highNote) {
        this.highNote = highNote;
    }

    public PianoNote getLowNote() {
        return this.lowNote;
    }

    public PianoNote getHighNote() {
        return this.highNote;
    }
}
