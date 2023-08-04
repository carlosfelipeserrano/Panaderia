/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author carlo
 */
public class PanesData {
        private static PanesData instance = null;
        private int idPanes;

        private PanesData() {
        }

        public static PanesData getInstance() {
            if (instance == null) {
                instance = new PanesData();
            }
            return instance;
        }

        public int getIdPanes() {
            return idPanes;
        }

        public void setIdPanes(int idPanes) {
            this.idPanes = idPanes;
        }
        


     
}
