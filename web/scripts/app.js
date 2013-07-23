/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    var a = Math.random() * 360;
    var opacity = Math.random() + .25;
    $(".bug-image")
        .css('transform', 'rotate(' + a + 'deg) scale(1)')
        .css('opacity', opacity);
});