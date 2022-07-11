

import 'package:dio/dio.dart';

import '../models/response/products_response.dart';
import '../network/endpoints/products_endpoint.dart';

class ProductsRepository {

  final ProductsEndpoint _productsEndpoint;

  ProductsRepository(this._productsEndpoint);

  Future<ProductsResponse> getProducts(int page) async {
    try {
      print('called');
      return await _productsEndpoint.getProducts();
    } catch (obj) {
      print(obj);
      switch (obj.runtimeType) {
        case DioError:
        // Here's the sample to get the failed response error code and message
          final res = (obj as DioError).response;
          return ProductsResponse.error(
            res?.statusCode ?? 0,
            res?.statusMessage ?? 'Something went\'s wrong!',
          );
        default:
          return ProductsResponse.error(
            0,
            'Unknown Error',
          );
      }
    }
  }
}