module.exports = function(app, create) {

  var Rest = require('../models/rest.js');

  if(create == 1)
  {
    var texts = new Array(); 

    texts[0] =  "Now that we know who you are, I know who I am. I'm not a mistake! It all makes sense! In a comic, you know how you can tell who the arch-villain's going to be? He's the exact opposite of the hero. And most times they're friends, like you and me! I should've known way back when... You know why, David? Because of the kids. They called me Mr Glass.";
    texts[1] = "Now that there is the Tec-9, a crappy spray gun from South Miami. This gun is advertised as the most popular gun in American crime. Do you believe that shit? It actually says that in the little book that comes with it: the most popular gun in American crime. Like they're actually proud of that shit. ";
    texts[2] = "The path of the righteous man is beset on all sides by the iniquities of the selfish and the tyranny of evil men. Blessed is he who, in the name of charity and good will, shepherds the weak through the valley of darkness, for he is truly his brother's keeper and the finder of lost children. And I will strike down upon thee with great vengeance and furious anger those who would attempt to poison and destroy My brothers. And you will know My name is the Lord when I lay My vengeance upon thee.";
    texts[3] = "Now that we know who you are, I know who I am. I'm not a mistake! It all makes sense! In a comic, you know how you can tell who the arch-villain's going to be? He's the exact opposite of the hero. And most times they're friends, like you and me! I should've known way back when... You know why, David? Because of the kids. They called me Mr Glass.";
    texts[4] = "Normally, both your asses would be dead as fucking fried chicken, but you happen to pull this shit while I'm in a transitional period so I don't wanna kill you, I wanna help you. But I can't give you this case, it don't belong to me. Besides, I've already been through too much shit this morning over this case to hand it over to your dumb ass.";
    texts[5] = "Look, just because I don't be givin' no man a foot massage don't make it right for Marsellus to throw Antwone into a glass motherfuckin' house, fuckin' up the way the nigger talks. Motherfucker do that shit to me, he better paralyze my ass, 'cause I'll kill the motherfucker, know what I'm sayin'?";
    for(var i = 0; i < 10000; i++){
      var rest = new Rest({
        ID: i,
        NAME: texts[Math.floor((Math.random()*texts.length))],
        NUMBER: i
      });

      rest.save(function(err) {
        if(!err) {
                console.log('Created');
        } else {
                console.log('ERROR: ' + err);
        }
      });
    }


  }

  findAll = function(req, res) {
          Rest.find(function(err, rests) {
            if(!err) {
                console.log('GET /rest')
                res.send(rests);
            } 
            else 
            {
                console.log('ERROR: ' + err);
            }
          });
  };

  app.get('/rest/all', findAll);
}