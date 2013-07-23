/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    var a = Math.random() * 360;
    $(".bug-image").css('transform', 'rotate(' + a + 'deg) scale(1)');
});