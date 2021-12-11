export interface ApiRequest<T> {
  data: T;
  loading: boolean;
  error: any;
}
