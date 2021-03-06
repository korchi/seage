    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.seage.problem.qap;

import java.io.FileInputStream;

/**
 *
 * @author Administrator
 */
public class QapTest {

    public static String _dataPath = "D:/esc16a.dat";
    public static Double[][][] facilityLocation;
    ///public static Object[] assign = {3,13,6,4,18,12,10,5,1,11,8,7,17,14,9,16,15,2};
//    public static Object[] assign ={1,2,6,4,8,3,7,5,14,13,16,15,9,11,10,12};
    private static Object[] assign = {1,5,7,6,9,11,10,3,4,2,14,15,16,13,8,12};
//    public static Object[] assign = {13,9,11,3,7,5,6,2,1,15,4,14,12,10,8,16};
    public static void main(String[] arg) throws Exception{
        facilityLocation = FacilityLocationProvider.readFacilityLocations(new FileInputStream(_dataPath) );
        System.out.println(evaluate(QapTest.assign)[0]);
    }


    public static double[] evaluate(Object[] phenotypeSubject) throws Exception
    {
        double assignPrice = 0;
        Double[][][] facilityLocation = QapTest.facilityLocation;
        int numFacilities = facilityLocation[0][0].length;

        double price = 0;
        for(int i=0;i<facilityLocation[0][0].length;i++){
            for(int j=0;j<facilityLocation[0][0].length;j++){
                price+=facilityLocation[0][i][j]*facilityLocation[1][(Integer)phenotypeSubject[i]-1][(Integer)phenotypeSubject[j]-1];
            }
        }
        double addition=0;
        for(int i=0;i<facilityLocation[0][0].length;i++){
            addition+=facilityLocation[2][i][(Integer)phenotypeSubject[i]-1];
        }

        return new double[] {price+addition};
    }
}
