var express = require("express"),
    app     = express(),
    http    = require("http"),
    mongoose = require('mongoose'),
    server  = http.createServer(app);


app.configure(function () {
  app.use(express.bodyParser());
  app.use(express.methodOverride());
  app.use(app.router);
});

app.get('/', function(req, res) {
  res.send("Hello world!");
});

process.argv.forEach(function (val, index, array) {
  console.log(index + ': ' + val);
});

var arguments = process.argv.splice(2);
if(undefined == arguments || '' == arguments)
{
  arguments = 0;
}
else
{
  arguments = 1;
}
console.log('Valor de create table is :'+ arguments);


routes = require('./routes/rests')(app,arguments);

mongoose.connect('mongodb://localhost/rests', function(err, res) {
  if(err) {
    console.log('ERROR: connecting to Database. ' + err);
  } else {
    console.log('Connected to Database');

  }
});

server.listen(3000, function() {
  console.log("Node server running on http://localhost:3000");
});