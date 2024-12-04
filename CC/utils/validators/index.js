const { validationResult } = require('express-validator');

const validateNote = (req, res) => {
  const errors = validationResult(req);

  if (!errors.isEmpty()) {
    res.status(422).json({
      success: false,
      message: 'Your request doesn\'t meet the requirements',
      errors: errors.array()
    })
    return false;
  }
  return true;
}

module.exports = validateNote