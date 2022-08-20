package com.example.shakil.data

import com.bumptech.glide.Glide.init
import com.example.shakil.model.Story
import kotlin.collections.ArrayList

object MockData {
    val stories = java.util.ArrayList<Story>()
    init {
        stories.add(Story("Sina.M","https://img.freepik.com/free-photo/waist-up-portrait-handsome-serious-unshaven-male-keeps-hands-together-dressed-dark-blue-shirt-has-talk-with-interlocutor-stands-against-white-wall-self-confident-man-freelancer_273609-16320.jpg?w=996&t=st=1660752984~exp=1660753584~hmac=96aadf36c237aef691556424fd2d5cf8c37a6089f0b4b6bc8c7384708963c4d8",true))
        stories.add(Story("M.Jafari","https://img.freepik.com/free-photo/playing-violin_1150-8374.jpg?w=900&t=st=1660757354~exp=1660757954~hmac=a8c731881bef3e1d2d3ce57eaa326208f97d6b5fbcd262c38808c248f944c814",false))
        stories.add(Story("Lucy Baker","https://img.freepik.com/free-photo/side-view-child-standing-karate-stance-studio_7502-4359.jpg?w=996&t=st=1660757403~exp=1660758003~hmac=16e95d5db2c220b55891588f6c89e7c1c161fa6fa1060833cc2480959fbf692a",false))
        stories.add(Story("Timmy Jon","https://img.freepik.com/free-photo/confident-young-handsome-cook-chef-uniform-standing-white-wall-isolated-orange-wall-with-copy-space_141793-101130.jpg?w=996&t=st=1660757468~exp=1660758068~hmac=79e7d221a4d7528031520e3152e1e6e077eb4385b959857ccde3c692ec319dfb",false))
        stories.add(Story("Brayan wick","https://img.freepik.com/free-photo/portrait-young-motivated-carpenter-standing-by-woodworking-machine-his-carpentry-workshop_342744-823.jpg?w=996&t=st=1660757542~exp=1660758142~hmac=f8ac3ce2caf87ffdd6ead77a5178be8f2b38c98e5b6802d5b7c5340258b13c46",false))
        stories.add(Story("Aslan sori","https://img.freepik.com/free-photo/mechanic-with-spanners-pockets_1170-1502.jpg?w=996&t=st=1660757503~exp=1660758103~hmac=fa5ddf8dab7239be1895841dec9b2bef9cd32cdca8cf07d4e2a2b2850bfa5885",false))
        stories.add(Story("Aslan sorisoriajkdfasdfhasfdgd","",false))
        stories.add(Story("Aslan soriajkdfasdfha;sljfas","",false))    }
}