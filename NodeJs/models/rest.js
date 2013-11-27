var mongoose = require('mongoose'),
    Schema   = mongoose.Schema;

var restSchema = new Schema({
  ID:       { type: Number },
  NAME:     { type: String }, 
  NUMBER:   { type: Number },  
});

module.exports = mongoose.model('Rest', restSchema);