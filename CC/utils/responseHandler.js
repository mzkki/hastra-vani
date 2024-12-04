const errorHandler = (err, req, res, next) => {
  console.error(err);
  res.status(500).json({
    success: false,
    message: 'Internal server error'
  });
}

const notFoundHandler = (req, res) => {
  res.status(404).json({
    success: false,
    message: 'Not Found'
  });
}

module.exports = { errorHandler, notFoundHandler };